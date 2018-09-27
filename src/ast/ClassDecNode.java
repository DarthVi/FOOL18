package ast;

import exception.*;
import lib.FOOLlib;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.*;
import util.Environment;
import util.SemanticError;
import util.DTableEntry;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
=======
import java.util.*;
import java.util.stream.Collectors;
>>>>>>> master

public class ClassDecNode implements INode
{
    private ClassType classType;
<<<<<<< HEAD
=======
    private String parentStr;
>>>>>>> master
    private ParserRuleContext ctx;
    //members declared in this class
    private ArrayList<MemberNode> members;
    private ArrayList<MethodNode> methods;
    //members declared in this class + its parent
    private ArrayList<MemberNode> allMembers;
    //private DTableEntry virtualFunctionTable;

<<<<<<< HEAD
    public ClassDecNode(ClassType classType, ArrayList<MemberNode> members,
                        ArrayList<MethodNode> methods, ParserRuleContext ctx)
    {
        this.classType = classType;
=======
    public ClassDecNode(ClassType classType, String parentStr, ArrayList<MemberNode> members,
                        ArrayList<MethodNode> methods, ParserRuleContext ctx)
    {
        this.classType = classType;
        this.parentStr = parentStr;
>>>>>>> master
        this.members = members;
        this.methods = methods;
        this.ctx = ctx;
        this.allMembers = new ArrayList<>();
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
    public String codeGeneration()
    {
        //TODO completare questo metodo
        return "";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();

        ArrayList<MemberNode> allMembers = new ArrayList<>();

        try
        {
            if(classType.getParent() == null)
                env.addClassType(((FOOLParser.ClassdecContext) (ctx)).ID(0).getSymbol(), classType);
            else
            {
<<<<<<< HEAD
                //we check if the declared parent exists, otherwise the method throws an exception
                ClassType parentType = env.getClassType(((FOOLParser.ClassdecContext) (ctx)).ID(1).getSymbol());
=======
                ClassType parentType = null;

                //we check if the declared parent exists, otherwise the method throws an exception
                if(this.parentStr != null)
                    parentType = env.getClassType(((FOOLParser.ClassdecContext) (ctx)).ID(1).getSymbol());

                this.classType.setParent(parentType);
>>>>>>> master

                //we set the current parent
                ClassType currentParent = classType.getParent();

                ArrayList<MethodNode> tempMethods = new ArrayList<>();
                Collections.copy(tempMethods, this.methods);

<<<<<<< HEAD
                ArrayList<String> overriddenMethods = new ArrayList<>();
=======
                ArrayList<MethodNode> overriddenMethods = new ArrayList<>();
>>>>>>> master

                //we must retrieve the parent members going up through the parent chain
                //we also must retrieve overridden methods
                while(currentParent != null)
                {
                    if (!currentParent.getClassMembers().values().isEmpty())
                    {
                        for (Object o : classType.getParent().getClassMembers().values())
                        {
                            ClassMember cm = (ClassMember) o;

                            MemberNode memberNode = new MemberNode(cm.getMemberID(), cm.getType(),  (FOOLParser.ArgdecContext) cm.getCtx());

                            allMembers.add(memberNode);
                        }
                    }

                    //get overridden methods
<<<<<<< HEAD
                    overriddenMethods.addAll(getOverriddenMethods(tempMethods, currentParent, env));
=======
                    overriddenMethods.addAll(getOverriddenMethods(tempMethods, currentParent));
>>>>>>> master

                    //overridden methods and new methods must have a new fresh label to be put
                    //inside this class' DFT
                    //for inherited not overridden methods we must get the old label and put it
                    //inside the current class DFT

                    currentParent = currentParent.getParent();
                }

                //checking that we are not overriding members, if not we add them to the member list
                //containing ALL the members
                for(MemberNode memberNode : members)
                {
                    String varName = memberNode.getId();

                    if(classType.getClassMembers().containsKey(varName))
                        throw new ClassMemberOverridingException(memberNode.getCtx().ID().getSymbol());

                    allMembers.add(memberNode);


                }

                env.addClassType(((FOOLParser.ClassdecContext) (ctx)).ID(0).getSymbol(),
                        ((FOOLParser.ClassdecContext) (ctx)).ID(1).getSymbol(),
                        classType);



                this.allMembers = allMembers;

                //adding a new scope

                env.addHashMap();
                //calling the checkSemantics on members: we need this to populate the symbol table and allow
                //class methods to see the class members
                for(MemberNode md : this.allMembers)
                    errors.addAll(md.checkSemantics(env));

                //building the DFT (dispatch function table) of this class, check function javadoc
                //and comments for details
                buildDftTable(overriddenMethods, tempMethods, classType.getParent(), env);

                //calling the checkSemantics on methods
                for(MethodNode fn : methods)
                    errors.addAll(fn.checkSemantics(env));

                //exiting the scope
                env.removeLastHashMap();

            }
        }catch (ClassAlreadyDefinedException
                | UndeclaredClassException
<<<<<<< HEAD
                | ClassMemberOverridingException e)
=======
                | ClassMemberOverridingException
                | MethodAlreadyDefinedException e)
>>>>>>> master
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
<<<<<<< HEAD
    public void buildDftTable(ArrayList<String> overriddenMethods, ArrayList<MethodNode> newMethods,
                              ClassType parent, Environment env)
=======
    @SuppressWarnings("Duplicates")
    public void buildDftTable(ArrayList<MethodNode> overriddenMethods, ArrayList<MethodNode> newMethods,
                              ClassType parent, Environment env) throws MethodAlreadyDefinedException
>>>>>>> master
    {
        //setting current class dft index to point appropriately to the new collection of dispatch tables
        int currentClassDftIndex = env.getDftSize();
        classType.setDftIndex(currentClassDftIndex);

<<<<<<< HEAD
=======
        //we need the collection made up of overriddenMethods string to ease up some operations
        //in line 236
        List<String> overriddenString =
                overriddenMethods.stream().map(MethodNode::getId).collect(Collectors.toList());

>>>>>>> master
        //this class' dispatch table
        HashMap<String, DTableEntry> dTable = new HashMap<>();

        //getting the index to the parent's dispatch table
        int parentDftIndex = parent.getDftIndex();

        //getting the parent's dispatch table
        HashMap<String, DTableEntry> parentTable = env.getDftTable(parentDftIndex);

        //we iterate through the parent's table, if we are not overriding, we inherit the method
        //simply by storing in the dTable the old function label previously set by the the parent
        for(Map.Entry<String, DTableEntry> entry : parentTable.entrySet())
        {
<<<<<<< HEAD
            if(!overriddenMethods.contains(entry.getKey()))
            {
                dTable.put(entry.getKey(), entry.getValue());
=======
            if(!overriddenString.contains(entry.getKey()))
            {
                DTableEntry check = dTable.put(entry.getKey(), entry.getValue());

                //checking for invalid multiple entries for the same function name
                if(check != null)
                    throw new MethodAlreadyDefinedException(entry.getValue().getCtx().ID().getSymbol());
>>>>>>> master
            }
        }

        //we generate a new label for each overridden method and store it in the dispatch table
<<<<<<< HEAD
        for(String methodName : overriddenMethods)
        {
            DTableEntry dTableEntry = new DTableEntry(methodName, FOOLlib.freshFunLabel());
            dTable.put(methodName, dTableEntry);
=======
        for(MethodNode methodNode : overriddenMethods)
        {
            DTableEntry dTableEntry = new DTableEntry(methodNode.getId(), FOOLlib.freshFunLabel(),
                    (FOOLParser.FunContext) methodNode.getCtx());

            DTableEntry check = dTable.put(methodNode.getId(), dTableEntry);

            //checking for invalid multiple entries for the same function name
            if(check != null)
                throw new MethodAlreadyDefinedException(
                        ((FOOLParser.FunContext) methodNode.getCtx()).ID().getSymbol());
>>>>>>> master
        }

        //generates new label for each new method, then stores it in the DFT
        for(MethodNode mn : newMethods)
        {
<<<<<<< HEAD
            DTableEntry dTableEntry = new DTableEntry(mn.getId(), FOOLlib.freshFunLabel());
            dTable.put(mn.getId(), dTableEntry);
=======
            DTableEntry dTableEntry = new DTableEntry(mn.getId(), FOOLlib.freshFunLabel(),
                    (FOOLParser.FunContext) mn.getCtx());
            DTableEntry check = dTable.put(mn.getId(), dTableEntry);

            //checking for invalid multiple entries for the same function name
            if(check != null)
                throw new MethodAlreadyDefinedException(
                        ((FOOLParser.FunContext) mn.getCtx()).ID().getSymbol());
>>>>>>> master
        }

        //adds the DFT to the collection of DFTs
        env.addDftTable(dTable);

    }

<<<<<<< HEAD
    public ArrayList<String> getOverriddenMethods(ArrayList<MethodNode> methods, ClassType parent, Environment env)
    {
        ArrayList<String> overriddenMethods = new ArrayList<>();
        for(MethodNode mn : methods)
        {
=======
    public ArrayList<MethodNode> getOverriddenMethods(ArrayList<MethodNode> methods,
                                                      ClassType parent)
    {
        ArrayList<MethodNode> overriddenMethods = new ArrayList<>();
        ListIterator<MethodNode> iter = methods.listIterator();

        while(iter.hasNext())
        {
            MethodNode mn = iter.next();
>>>>>>> master
            String mName = mn.getId();

            ClassMethod childMethod = (ClassMethod) classType.getClassMethods().get(mName);

            ClassMethod parentMethod = (ClassMethod) parent.getClassMethods().get(mName);

<<<<<<< HEAD
            if (childMethod.getMethodType().isOverriding(parentMethod.getMethodType()))
            {
                overriddenMethods.add(mn.getId());
                methods.remove(mn);
=======
            if (parentMethod != null &&
                    childMethod.getMethodType().isOverriding(parentMethod.getMethodType()))
            {
                overriddenMethods.add(mn);
                iter.remove();
>>>>>>> master
            }
        }

        return overriddenMethods;
    }

    @Override
    public String toString()
    {
        return "ClassDecNode: " + classType.toString();
    }
}
