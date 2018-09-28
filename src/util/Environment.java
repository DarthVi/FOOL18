package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

import exception.*;
import lib.FOOLlib;
import org.antlr.v4.runtime.Token;
import type.ClassType;
import type.FunctionType;
import type.IType;

public class Environment
{
    public int offset = 0;
    private ArrayList<HashMap<String,STentry>> symTable;

    //map from string to defined class declarations
    private HashMap<String, ClassType> symClassTypes;

    //dispatch function table
    HashMap<String, HashMap<String, DTableEntry> > dispatchTables;

    public Environment(ArrayList<HashMap<String, STentry>> symTable, HashMap<String, ClassType> symClassTypes,
                       HashMap<String, HashMap<String, DTableEntry> > vtable)
    {

        this.symTable = symTable;
        this.symClassTypes = symClassTypes;
        this.dispatchTables = vtable;
    }

    public Environment()
    {
        symTable = new ArrayList<HashMap<String,STentry>>();
        dispatchTables = new HashMap<>();
        symClassTypes = new HashMap<>();
    }

    /**
     * gets the current nesting level
     * @return  int - current nesting level
     */
    public int getNestingLevel()
    {
        return this.symTable.size() - 1;
    }

    /**
     * Adds a new entry in the latest hashmap of the symbol table.
     * @param variableNameToken     the token with the information to store
     * @param type                  the type of the variable
     * @param offset                the offset in the AR of the variable
     * @param isAttribute           true if it is a class attribute, false otherwise
     * @return                      this Environment
     * @throws VariableAlreadyDefinedException
     */
    public Environment addEntry(Token variableNameToken, IType type, int offset,
                                boolean isAttribute) throws VariableAlreadyDefinedException
    {
        String id = variableNameToken.getText();
        STentry newEntry = new STentry(getNestingLevel(), type, offset, isAttribute);
        STentry checkEntry = symTable.get(symTable.size() - 1).put(id, newEntry);

        if(checkEntry != null && !(checkEntry.getType() instanceof FunctionType))
        {
            throw new VariableAlreadyDefinedException(variableNameToken);
        }
        else if(checkEntry != null)
        {

            throw new FunctionAlreadyDefinedException(variableNameToken);

            //old code to support overloading, which however may create ambiguous situations
            //when we have the same parameter numbers and return type, but different
            //class in parameters

            /*FunctionType typeWeWantToAdd = (FunctionType) type;
            FunctionType typeFound = (FunctionType) checkEntry.getType();

            //we must check for function overloading
            if(!typeWeWantToAdd.isOverloading(typeFound))
                throw new FunctionAlreadyDefinedException(variableNameToken);
            else
            {

                //we add overloaded function adding an integer/index to the function name
                //this way we are able to put new overloaded function in the symbol table
                int i = 1;

                do
                {
                    id += i;
                    checkEntry = symTable.get(symTable.size() - 1).put(id, newEntry);
                    i++;
                }while(checkEntry != null);
            }*/
        }

        return this;
    }

    /**
     * Pushes a new hashmap at the end of the list
     * @return  this - the currently modified Environment
     */
    public Environment addHashMap()
    {
        this.symTable.add(new HashMap<>());
        return this;
    }

    /**
     * Pops the latest hashmap added
     * @return  this - the currently modified Environment
     */
    public Environment removeLastHashMap()
    {
        this.symTable.remove(this.symTable.size() - 1);
        return this;
    }

    /**
     * Returns the latest entry corresponding to the token searched
     * @param token
     * @return
     * @throws UndeclaredVariableException
     */
    public STentry getEntry(Token token) throws UndeclaredVariableException
    {
        String id = token.getText();
        ListIterator<HashMap<String, STentry>> li = this.symTable.listIterator(this.symTable.size());
        STentry entry = null;

        while(li.hasPrevious())
        {
            HashMap<String, STentry> map = li.previous();

            if((entry = map.get(id)) != null)
                break;
        }

        if(entry == null)
            throw new UndeclaredVariableException(token);

        return entry;
    }

    /**
     * Returns the latest entry corresponding to the token searched
     * @param token
     * @return
     * @throws UndefinedFunctionException
     */
    public STentry getFunEntry(Token token) throws UndefinedFunctionException
    {
        String id = token.getText();
        ListIterator<HashMap<String, STentry>> li = this.symTable.listIterator(this.symTable.size());
        STentry entry = null;

        while(li.hasPrevious())
        {
            HashMap<String, STentry> map = li.previous();

            if((entry = map.get(id)) != null)
                break;
        }

        if(entry == null)
            throw new UndefinedFunctionException(token);

        return entry;
    }

    public void addClassType(Token name, ClassType classType) throws ClassAlreadyDefinedException
    {
        ClassType current = symClassTypes.put(name.getText(), classType);

        if(current != null)
            throw new ClassAlreadyDefinedException(name);
    }

    public void addClassType(Token name, Token parent, ClassType classType) throws ClassAlreadyDefinedException,
            UndeclaredClassException
    {
        ClassType checkParent = symClassTypes.get(parent.getText());

        if(checkParent == null)
            throw new UndeclaredClassException(parent);

        ClassType current = symClassTypes.put(name.getText(), classType);

        if(current != null)
            throw new ClassAlreadyDefinedException(name);
    }

    public ClassType getClassType(Token name) throws UndeclaredClassException
    {
        ClassType type = symClassTypes.get(name.getText());

        if(type == null)
            throw new UndeclaredClassException(name);

        return type;
    }

    public IType getTypeOf(Token token)
    {
        return this.getEntry(token).getType();
    }

    public int getDftSize()
    {
        return dispatchTables.size();
    }

    public HashMap<String, DTableEntry> getDftTable(String classname)
    {
        return this.dispatchTables.get(classname);
    }

    public void addDftTable(String name, HashMap<String, DTableEntry> table)
    {
        this.dispatchTables.put(name, table);
    }

//    public String generateDFTCode()
//    {
//        String funCode = FOOLlib.getfun();
//
//        StringBuilder sb = new StringBuilder();
//
//        for(int i = 0; i < dispatchTables.size(); i++)
//        {
//            HashMap<String, DTableEntry> entry = dispatchTables.get(i);
//            sb.append("class" + entry.)
//        }
//    }
}
