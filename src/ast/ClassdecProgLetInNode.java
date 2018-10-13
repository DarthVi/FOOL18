package ast;

import exception.*;
import lib.FOOLlib;
import parser.FOOLParser;
import type.*;
import util.DTableEntry;
import util.Environment;
import util.SemanticError;

import java.util.*;
import java.util.stream.Collectors;

public class ClassdecProgLetInNode implements INode
{
    //list containing class declarations
    private ArrayList<ClassDecNode> classdecs;
    //LetNode, which contains declarations
    private INode letPart;
    //according to the grammar we can either have exp or stast
    private INode exp;
    private Environment env;
    private ArrayList<INode> stats;
    HashMap<String, String> fromIdtoLabelFunc = new HashMap<>();

    public ClassdecProgLetInNode(ArrayList<ClassDecNode> classdecs, INode letPart, INode exp, ArrayList<INode> stats)
    {
        this.classdecs = classdecs;
        this.letPart = letPart;
        this.exp = exp;
        this.stats = stats;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public IType typeCheck() throws TypeException
    {
        //typecheck for each class declaration
        for(ClassDecNode cn : classdecs)
            cn.typeCheck();

        if(letPart != null)
        {
            letPart.typeCheck();

        }

        if (exp != null)
            return exp.typeCheck();
        else
        {
            for (INode stat : stats)
            {
                stat.typeCheck();
            }

            return new VoidType();
        }
    }

    @Override
    public String codeGeneration() {

        //per generare il codice delle classi che sarà poi inserito da env.codeGeneration
        for (ClassDecNode c: classdecs) c.codeGeneration();

        StringBuilder s = new StringBuilder();


        if (letPart != null) s.append(letPart.codeGeneration());
        if (exp != null) s.append(exp.codeGeneration());
        if(!stats.isEmpty())
        {
            for(INode stat : stats)
                s.append(stat.codeGeneration());
        }
        s.append("halt\n").append(env.generateCode()).append("classnull:\n");;

        return s.toString();
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();

        try
        {
            for (ClassDecNode cn : classdecs)
            {
                ClassType classType = cn.getClassType();
                //we build the classtype information for members
                HashMap<String, ClassMember> classMembers = new HashMap<>();
                for (MemberNode mn : cn.getMembers())
                {
                    ClassMember mb = new ClassMember(mn.getId(), mn.getType(), mn.getCtx());
                    classMembers.put(mn.getId(), mb);
                }

                classType.setClassMembers(classMembers);

                //building classtype information for methods
                HashMap<String, ClassMethod> classMethods = new HashMap<>();
                for (MethodNode mn : cn.getMethods())
                {
                    ClassMethod mm = new ClassMethod(mn.getId(), mn.getFunctionType());
                    classMethods.put(mn.getId(), mm);
                }

                classType.setClassMethods(classMethods);

                if(cn.getParentStr() == null)
                {
                    classType.setClassMethods(classMethods);

                    env.addClassType(((FOOLParser.ClassdecContext) (cn.getCtx())).ID(0).getSymbol(), classType);

                    //building the DFT (dispatch function table) of this class, check function javadoc
                    //and comments for details
                    buildDftTable(classType, new ArrayList<>(), cn.getMethods(), null, env);
                }
                else
                {
                    ClassType parentType = null;
                    //we check if the declared parent exists, otherwise the method throws an exception
                    parentType = env.getClassType(((FOOLParser.ClassdecContext) (cn.getCtx())).ID(1).getSymbol());

                    classType.setParent(parentType);

                    //we set the current parent
                    ClassType currentParent = classType.getParent();

                    ArrayList<MethodNode> tempMethods = new ArrayList<>(cn.getMethods());

                    ArrayList<MethodNode> overriddenMethods = new ArrayList<>();

                    //we must check that the constructor has all the members of the parent
                    for(Object o : currentParent.getClassMembers().values())
                    {
                        ClassMember parentMember = (ClassMember) o;

                        if(!cn.getMembers().stream().map(MemberNode::getId).collect(Collectors.toList()).contains(
                                parentMember.getMemberID()))
                        {
                            throw new MissingMemberException(((FOOLParser.ClassdecContext) (cn.getCtx())).
                                    ID(0).getSymbol(), ((FOOLParser.ClassdecContext) (cn.getCtx())).
                                    ID(0).getSymbol().getText(), parentMember.getMemberID());
                        }
                        else
                        {
                            ClassMember childMember = (ClassMember) classType.getClassMembers()
                                    .get(parentMember.getMemberID());

                            //checking that the subclass correctly use the type of the parent member without overriding it
                            if(!childMember.getType().toString().equals(parentMember.getType().toString()))
                            {
                                throw new ClassMemberOverridingException(((FOOLParser.ClassdecContext) (cn.getCtx())).
                                        ID(0).getSymbol());
                            }
                        }
                    }

                    for(int i= 0; i < parentType.getDeclaredOrderMembers().size(); i++)
                    {
                        if(!parentType.getDeclaredOrderMembers().get(i).getMemberID().equals(cn.getMembers().get(i).getId()))
                        {
                            throw new IncorrectOrderConstructorException(((FOOLParser.ClassdecContext) (cn.getCtx())).
                                    ID(0).getSymbol());
                        }
                    }

                    //we must retrieve parent methods to check for overrides

                    //get overridden methods
                    overriddenMethods.addAll(getOverriddenMethods(classType, tempMethods, currentParent));

                    //inheriting parent's not overridden methods
                    List<String> overriddenString =
                            overriddenMethods.stream().map(MethodNode::getId).collect(Collectors.toList());
                    for(Object o : parentType.getClassMethods().values())
                    {
                        ClassMethod cm = (ClassMethod) o;

                        if(!overriddenString.contains(cm.getMethodID()))
                            classMethods.put(cm.getMethodID(), cm);
                    }

                    classType.setClassMethods(classMethods);

                    //overridden methods and new methods must have a new fresh label to be put
                    //inside this class' DFT
                    //for inherited not overridden methods we must get the old label and put it
                    //inside the current class DFT


                    env.addClassType(((FOOLParser.ClassdecContext) (cn.getCtx())).ID(0).getSymbol(),
                            ((FOOLParser.ClassdecContext) (cn.getCtx())).ID(1).getSymbol(),
                            classType);

                    //building the DFT (dispatch function table) of this class, check function javadoc
                    //and comments for details
                    buildDftTable(classType, overriddenMethods, tempMethods, classType.getParent(), env);
                }

                //we need this to allow the user to make a new call (new Object(..))
                //and using inside the constructor the same ordering defined
                //here during class declaration
                ArrayList<ClassMember> membersOrderedAsDeclaration = new ArrayList<>();
                for(MemberNode mn : cn.getMembers())
                {
                    ClassMember cm = new ClassMember(mn.getId(), mn.getType(), mn.getCtx());
                    membersOrderedAsDeclaration.add(cm);
                }

                classType.setDeclaredOrderMembers(membersOrderedAsDeclaration);

                cn.setFromIdtoLabelFunc(new HashMap<>(fromIdtoLabelFunc));
                fromIdtoLabelFunc = new HashMap<>();

            }
        }catch (ClassAlreadyDefinedException
                | UndeclaredClassException
                | ClassMemberOverridingException
                | MethodAlreadyDefinedException
                | MissingMemberException
                | IncorrectOrderConstructorException e)
        {
            errors.add(new SemanticError(e.getMessage()));
        }

        //semantic check for each class declaration
        for(ClassDecNode cn : classdecs)
            errors.addAll(cn.checkSemantics(env));

        if(!errors.isEmpty())
            return errors;

        //let's add a new scope
        env.addHashMap();
        env.offset = -2;

        if(letPart != null)
        {
            //semantic check for the let part
            errors.addAll(((LetNode) letPart).checkSemantics(env));
            //semantic check for the body (exp or stats)

        }

        if (exp != null)
            errors.addAll(exp.checkSemantics(env));
        else
        {
            for (INode stat : stats)
                errors.addAll(stat.checkSemantics(env));
        }

        //exiting the scope
        env.removeLastHashMap();

        this.env = env;

        return errors;
    }


    @Override
    public String toString()
    {
        //TODO
        return super.toString();
    }

    public ArrayList<MethodNode> getOverriddenMethods(ClassType currentClass, ArrayList<MethodNode> methods,
                                                      ClassType parent)
    {
        ArrayList<MethodNode> overriddenMethods = new ArrayList<>();
        ListIterator<MethodNode> iter = methods.listIterator();

        while(iter.hasNext())
        {
            MethodNode mn = iter.next();
            String mName = mn.getId();

            ClassMethod childMethod = (ClassMethod) currentClass.getClassMethods().get(mName);

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
    public void buildDftTable(ClassType currentClass, ArrayList<MethodNode> overriddenMethods, ArrayList<MethodNode> newMethods,
                              ClassType parent, Environment env) throws MethodAlreadyDefinedException
    {
        //this is used for checking correctness
        HashMap<String, DTableEntry> dTable = new HashMap<>();
        //this class' dispatch table
        ArrayList<DTableEntry> effectiveDtable = new ArrayList<>();

        //setting current class dft index to point appropriately to the new collection of dispatch tables
        String currentClassDftIndex = currentClass.getClassName();

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
                else
                {
                    //we generate a new label for each overridden method and store it in the dispatch table
                    int index = overriddenString.indexOf(entry.getMethodId());
                    MethodNode mn = overriddenMethods.get(index);

                    String label = FOOLlib.freshFunLabel();
                    DTableEntry dTableEntry = new DTableEntry(mn.getId(), label,
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
}
