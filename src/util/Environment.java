package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import exception.UndeclaredVariableException;
import exception.VariableAlreadyDefinedException;
import org.antlr.v4.runtime.Token;
import type.IType;
import vm.VTableEntry;

public class Environment
{
    private ArrayList<HashMap<String,STentry>> symTable;

    //virtual table
    Map<Integer, ArrayList<VTableEntry>> virtualTables;

    public Environment(ArrayList<HashMap<String, STentry>> symTable, Map<Integer, ArrayList<VTableEntry>> vtable)
    {

        this.symTable = symTable;
        this.virtualTables = vtable;
    }

    public Environment()
    {
        symTable = new ArrayList<HashMap<String,STentry>>();
        virtualTables = new HashMap<>();
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

        if(checkEntry != null)
        {
            throw new VariableAlreadyDefinedException(variableNameToken);
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
        STentry entry = null;

        for(HashMap<String, STentry> map : symTable)
        {
            if((entry = map.get(id)) != null)
                break;
        }

        if(entry == null)
            throw new UndeclaredVariableException(token);

        return entry;
    }

    public IType getTypeOf(Token token)
    {
        return this.getEntry(token).getType();
    }
    //TODO: check if using Tokens instead of Strings is ok
}
