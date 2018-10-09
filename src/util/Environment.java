package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

import exception.*;
import lib.FOOLlib;
import org.antlr.v4.runtime.Token;
import type.ClassType;
import type.FunctionType;
import type.IType;

public class Environment
{
    public int offset = 0;
    public ArrayList<HashMap<String,STentry>> symTable;

    //map from string to defined class declarations
    private HashMap<String, ClassType> symClassTypes;

    //dispatch function table
    HashMap<String, ArrayList<DTableEntry> > dispatchTables;

    public Environment(ArrayList<HashMap<String, STentry>> symTable, HashMap<String, ClassType> symClassTypes,
                       HashMap<String, ArrayList<DTableEntry> > vtable)
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

    public Environment addEntry(String id, IType type, int offset,
                         boolean isAttribute) throws VariableAlreadyDefinedException
    {
        STentry newEntry = new STentry(getNestingLevel(), type, offset, isAttribute);
        STentry checkEntry = symTable.get(symTable.size() - 1).put(id, newEntry);

        if(checkEntry != null)
        {
            throw new VariableAlreadyDefinedException(id);
        }

        return this;
    }

    public Environment addEntry(String id, STentry entry)
    {
        symTable.get(symTable.size() - 1).put(id, entry);
        return this;
    }

    @SuppressWarnings("Duplicates")
    public Environment updateIsNull(String id, boolean isNull)
    {
        ListIterator<HashMap<String, STentry>> li = this.symTable.listIterator(this.symTable.size());
        STentry entry = null;

        while(li.hasPrevious())
        {
            HashMap<String, STentry> map = li.previous();

            if((entry = map.get(id)) != null)
            {
                entry.setNull(isNull);
                map.put(id, entry);
                break;
            }
        }

        return this;
    }

    @SuppressWarnings("Duplicates")
    public Environment updateIsAttribute(String id, boolean isAttribute)
    {
        ListIterator<HashMap<String, STentry>> li = this.symTable.listIterator(this.symTable.size());
        STentry entry = null;

        while(li.hasPrevious())
        {
            HashMap<String, STentry> map = li.previous();

            if((entry = map.get(id)) != null)
            {
                entry.setNull(isAttribute);
                map.put(id, entry);
                break;
            }
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

    public STentry getEntry(String id) throws UndeclaredVariableException
    {
        ListIterator<HashMap<String, STentry>> li = this.symTable.listIterator(this.symTable.size());
        STentry entry = null;

        while(li.hasPrevious())
        {
            HashMap<String, STentry> map = li.previous();

            if((entry = map.get(id)) != null)
                break;
        }

        if(entry == null)
            throw new UndeclaredVariableException(id);

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

    public ClassType getClassType(String name) throws UndeclaredClassException
    {
        ClassType type = symClassTypes.get(name);

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

    public ArrayList<DTableEntry> getDftTable(String classname)
    {
        return this.dispatchTables.get(classname);
    }

    public void addDftTable(String name, ArrayList<DTableEntry> table)
    {
        this.dispatchTables.put(name, table);
    }

    /**
     * Generate the code for functions and dispatch function table
     * @return
     */
    public String generateCode()
    {
        //we get all the function defined
        StringBuilder sb = new StringBuilder(FOOLlib.getfun());

        //we add at the end the appropriate function label for each class
        //according to the dispatch function table
        //example:
        //classPippo:
        //funlabel1
        //funlabel2
        //classPluto:
        //funlabel1
        //funlabel3
        for (Map.Entry<String, ArrayList<DTableEntry>> entry : dispatchTables.entrySet())
        {
            String classID = entry.getKey();

            sb.append("class").append(classID).append(":\n");

            ArrayList<DTableEntry> table = entry.getValue();

            for(DTableEntry dtEntry : table)
            {
                sb.append(dtEntry.getMethodLabel()).append("\n");
            }
        }

        return sb.toString();
    }

    public STentry checkEntryPresence(String id)
    {
        return symTable.get(symTable.size() -1 ).get(id);
    }
}
