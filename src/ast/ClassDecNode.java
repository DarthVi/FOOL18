package ast;

import exception.*;
import lib.FOOLlib;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.*;
import util.Environment;
import util.SemanticError;
import util.DTableEntry;

import java.util.*;
import java.util.stream.Collectors;

public class ClassDecNode implements INode
{
    private ClassType classType;
    private String parentStr;
    private ParserRuleContext ctx;
    //members declared in this class
    private ArrayList<MemberNode> members;
    private ArrayList<MethodNode> methods;
    //private DTableEntry virtualFunctionTable;
    HashMap<String, String> fromIdtoLabelFunc = new HashMap<>();



    public ClassDecNode(ClassType classType, String parentStr, ArrayList<MemberNode> members,
                        ArrayList<MethodNode> methods, ParserRuleContext ctx)
    {
        this.classType = classType;
        this.parentStr = parentStr;
        this.members = members;
        this.methods = methods;
        this.ctx = ctx;
    }


    @Override
    public IType typeCheck() throws TypeException
    {
        try
        {
            ClassType currentParent = classType.getParent();

            //we check if overrides are correct through the whole parent chain
            //Example to explain why this is necessary:
            //we have 3 classes, a "grandparent" a "parent" and a "child"; the child
            //may override none of the parent's methods but some of the granparent's ones.
            while (currentParent != null)
            {

                //checking if methods are overridden correctly.

                //we use the context to iterate because we need the token info to display
                //the errors (if any) appropriately (with info about lines and columns). Otherwise
                //we could have used ClassMethod got from classType right here
                for (FOOLParser.FunContext fc : ((FOOLParser.ClassdecContext) (ctx)).fun())
                {
                    String methodName = fc.ID().getText();

                    if (currentParent.getClassMethods().containsKey(methodName))
                    {
                        ClassMethod childMethod = (ClassMethod) classType.getClassMethods().get(methodName);

                        ClassMethod parentMethod = (ClassMethod) currentParent.getClassMethods().get(methodName);

                        //if a method has the same name of a parent's method and it does not override it
                        //correctly, then throw an exception
                        if (!childMethod.getMethodType().isOverriding(parentMethod.getMethodType()))
                            throw new OverrideErrorException(fc.ID().getSymbol());
                    }
                }

                currentParent = currentParent.getParent();
            }
        }
        catch(OverrideErrorException e)
        {
            throw new TypeException(e.getMessage(), ctx);
        }

        return this.classType;
    }



    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();


        try
        {
            if(this.parentStr == null)
            {
                env.addClassType(((FOOLParser.ClassdecContext) (ctx)).ID(0).getSymbol(), classType);

                //building the DFT (dispatch function table) of this class, check function javadoc
                //and comments for details
                buildDftTable(new ArrayList<>(), this.methods, null, env);

            }
            else
            {
                ClassType parentType = null;

                //we check if the declared parent exists, otherwise the method throws an exception
                parentType = env.getClassType(((FOOLParser.ClassdecContext) (ctx)).ID(1).getSymbol());

                this.classType.setParent(parentType);

                //we set the current parent
                ClassType currentParent = classType.getParent();

                ArrayList<MethodNode> tempMethods = new ArrayList<>(this.methods);

                ArrayList<MethodNode> overriddenMethods = new ArrayList<>();

                //we must check that the constructor has all the members of the parent
                for(Object o : currentParent.getClassMembers().values())
                {
                    ClassMember parentMember = (ClassMember) o;

                    if(!this.members.stream().map(MemberNode::getId).collect(Collectors.toList()).contains(
                            parentMember.getMemberID()))
                    {
                        throw new MissingMemberException(((FOOLParser.ClassdecContext) (ctx)).
                                ID(0).getSymbol(), ((FOOLParser.ClassdecContext) (ctx)).
                                ID(0).getSymbol().getText(), parentMember.getMemberID());
                    }
                    else
                    {
                        ClassMember childMember = (ClassMember) this.classType.getClassMembers()
                                .get(parentMember.getMemberID());

                        //checking that the subclass correctly use the type of the parent member without overriding it
                        if(!childMember.getType().toString().equals(parentMember.getType().toString()))
                        {
                            throw new ClassMemberOverridingException(((FOOLParser.ClassdecContext) (ctx)).
                                    ID(0).getSymbol());
                        }
                    }
                }

                //we must retrieve parent methods going up through the parent chain
                while(currentParent != null)
                {
                    //get overridden methods
                    overriddenMethods.addAll(getOverriddenMethods(tempMethods, currentParent));

                    //overridden methods and new methods must have a new fresh label to be put
                    //inside this class' DFT
                    //for inherited not overridden methods we must get the old label and put it
                    //inside the current class DFT

                    currentParent = currentParent.getParent();
                }

                env.addClassType(((FOOLParser.ClassdecContext) (ctx)).ID(0).getSymbol(),
                        ((FOOLParser.ClassdecContext) (ctx)).ID(1).getSymbol(),
                        classType);


                //building the DFT (dispatch function table) of this class, check function javadoc
                //and comments for details
                buildDftTable(overriddenMethods, tempMethods, classType.getParent(), env);

            }


            //we need this to allow the user to make a new call (new Object(..))
            //and using inside the constructor the same ordering defined
            //here during class declaration
            ArrayList<ClassMember> membersOrderedAsDeclaration = new ArrayList<>();
            for(MemberNode mn : this.members)
            {
                ClassMember cm = new ClassMember(mn.getId(), mn.getType(), mn.getCtx());
                membersOrderedAsDeclaration.add(cm);
            }
            this.classType.setDeclaredOrderMembers(membersOrderedAsDeclaration);

            //adding a new scope
            env.addHashMap();
            //calling the checkSemantics on members: we need this to populate the symbol table and allow
            //class methods to see the class members
            for(MemberNode md : this.members)
                errors.addAll(md.checkSemantics(env));

            //In order to be able tu use mutual recursion,
            //we must add all the methods to the symbol table before calling each method's
            //checkSemantics
            for(MethodNode fn : methods)
            {
                //setting the ClassType we must refer to for this MethodNode.
                //This way we can use this information inside MethodNode when needed.
                fn.setClassType(this.classType);
                FunctionType fnType = fn.getFunctionType();

                //lets add here the signature of the function to the symbol table,
                //in order to support mutual recursion
                env.addEntry(((FOOLParser.FunContext) (fn.getCtx())).ID().getSymbol(),
                        fnType, env.offset--, true);
            }

            //calling the checkSemantics on methods
            for(MethodNode fn: methods)
                errors.addAll(fn.checkSemantics(env));

            //exiting the scope
            env.removeLastHashMap();

        }catch (ClassAlreadyDefinedException
                | UndeclaredClassException
                | ClassMemberOverridingException
                | MethodAlreadyDefinedException
                | MissingMemberException e)
        {
            errors.add(new SemanticError(e.getMessage()));
        }


        return errors;
    }

    /** Overridden methods and new methods must have a new fresh label to be put
     *  inside this class' DFT.
     *  For inherited not overridden methods we must get the old label and put it
     *  inside the current class DFT
     * @param overriddenMethods
     * @param newMethods
     * @param parent
     * @param env
     */
    @SuppressWarnings("Duplicates")
    public void buildDftTable(ArrayList<MethodNode> overriddenMethods, ArrayList<MethodNode> newMethods,
                              ClassType parent, Environment env) throws MethodAlreadyDefinedException
    {
        //this is used for checking correctness
        HashMap<String, DTableEntry> dTable = new HashMap<>();
        //this class' dispatch table
        ArrayList<DTableEntry> effectiveDtable = new ArrayList<>();

        //setting current class dft index to point appropriately to the new collection of dispatch tables
        String currentClassDftIndex = this.getClassID();

        if(parent == null)
        {
            //generates new label for each new method, then stores it in the DFT
            for (MethodNode mn : newMethods)
            {
                String label = FOOLlib.freshFunLabel();
                DTableEntry dTableEntry = new DTableEntry(mn.getId(),label,
                        (FOOLParser.FunContext) mn.getCtx());
                DTableEntry check = dTable.put(mn.getId(), dTableEntry);
                effectiveDtable.add(dTableEntry);
                fromIdtoLabelFunc.put(mn.getId(), label);

                //checking for invalid multiple entries for the same function name
                if (check != null)
                    throw new MethodAlreadyDefinedException(
                            ((FOOLParser.FunContext) mn.getCtx()).ID().getSymbol());
            }
        }
        else
        {
            //we need the collection made up of overriddenMethods string to ease up some operations
            //in line 255
            List<String> overriddenString =
                    overriddenMethods.stream().map(MethodNode::getId).collect(Collectors.toList());

            //getting the index to the parent's dispatch table
            String parentDftIndex = parent.getClassName();

            //getting the parent's dispatch table
            ArrayList<DTableEntry> parentTable = env.getDftTable(parentDftIndex);

            //we iterate through the parent's table, if we are not overriding, we inherit the method
            //simply by storing in the dTable the old function label previously set by the the parent
            for (DTableEntry entry : parentTable)
            {
                if (!overriddenString.contains(entry.getMethodId()))
                {
                    DTableEntry check = dTable.put(entry.getMethodId(), entry);
                    effectiveDtable.add(entry);

                    //checking for invalid multiple entries for the same function name
                    if (check != null)
                        throw new MethodAlreadyDefinedException(entry.getCtx().ID().getSymbol());
                }
            }

            //we generate a new label for each overridden method and store it in the dispatch table
            for (MethodNode methodNode : overriddenMethods)
            {
                String label = FOOLlib.freshFunLabel();
                DTableEntry dTableEntry = new DTableEntry(methodNode.getId(), label,
                        (FOOLParser.FunContext) methodNode.getCtx());

                DTableEntry check = dTable.put(methodNode.getId(), dTableEntry);
                effectiveDtable.add(dTableEntry);
                fromIdtoLabelFunc.put(methodNode.getId(), label);

                //checking for invalid multiple entries for the same function name
                if (check != null)
                    throw new MethodAlreadyDefinedException(
                            ((FOOLParser.FunContext) methodNode.getCtx()).ID().getSymbol());
            }

            //generates new label for each new method, then stores it in the DFT
            for (MethodNode mn : newMethods)
            {
                String label = FOOLlib.freshFunLabel();
                DTableEntry dTableEntry = new DTableEntry(mn.getId(),label,
                        (FOOLParser.FunContext) mn.getCtx());
                DTableEntry check = dTable.put(mn.getId(), dTableEntry);
                effectiveDtable.add(dTableEntry);
                fromIdtoLabelFunc.put(mn.getId(), label);

                //checking for invalid multiple entries for the same function name
                if (check != null)
                    throw new MethodAlreadyDefinedException(
                            ((FOOLParser.FunContext) mn.getCtx()).ID().getSymbol());
            }
        }

        //adds the DFT to the collection of DFTs
        env.addDftTable(currentClassDftIndex, effectiveDtable);
    }

    public ArrayList<MethodNode> getOverriddenMethods(ArrayList<MethodNode> methods,
                                                      ClassType parent)
    {
        ArrayList<MethodNode> overriddenMethods = new ArrayList<>();
        ListIterator<MethodNode> iter = methods.listIterator();

        while(iter.hasNext())
        {
            MethodNode mn = iter.next();
            String mName = mn.getId();

            ClassMethod childMethod = (ClassMethod) classType.getClassMethods().get(mName);

            ClassMethod parentMethod = (ClassMethod) parent.getClassMethods().get(mName);

            if (parentMethod != null &&
                    childMethod.getMethodType().isOverriding(parentMethod.getMethodType()))
            {
                overriddenMethods.add(mn);
                iter.remove();
            }
        }

        return overriddenMethods;
    }

    @Override
    public String toString()
    {
        return "ClassDecNode: " + classType.toString();
    }

    @Override
    public String codeGeneration()
    {
        //generazione del codice dei metodi, passato come parametro la label della funzione
        for (MethodNode m:methods) {
            m.codeGeneration(fromIdtoLabelFunc.get(m.getId()));
        }

        //TODO completare questo metodo
        //dovrebbe bastare, perchè la creazione della DispatchTableEntry viene fatta nelle funzioni sopra
        return "";
    }

    public String getClassID() {
        return classType.toString();
    }

    public String getSuperClassID() {
        return this.parentStr;
    }



}
