package ast;

import exception.TypeException;
import type.ClassType;
import type.IType;
import util.Environment;
import util.SemanticError;
import vm.VTableEntry;

import java.util.ArrayList;

public class ClassNode implements INode
{
    private ClassType classType;
    private VTableEntry virtualFunctionTable;


    //TODO: completare questo codice

    @Override
    public IType typeCheck() throws TypeException
    {
        //TODO: controllare che, in caso di ereditarietà, l'overriding dei metodi sia fatto correttamente
        return this.classType;
    }

    @Override
    public String codeGeneration()
    {
        return "";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        //TODO: controllare che la classe non sia già stata definita precedentemente
        //TODO: controllare che, in caso di ereditarietà, non stiamo overridando i membri
        return null;
    }
}
