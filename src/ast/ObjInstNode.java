package ast;

import exception.TypeException;
import type.ClassType;
import type.IType;
import util.Environment;
import util.SemanticError;
import vm.DTableEntry;

import java.util.ArrayList;

public class ObjInstNode implements INode
{
    //TODO
    private String objectName;
    private ClassType classType;
    private DTableEntry virtualFunctionTable;

    public ObjInstNode(String objectName, ClassType classType, DTableEntry vft)
    {
        this.objectName = objectName;
        this.classType = classType;
        this.virtualFunctionTable = vft;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        return this.classType;
    }

    @Override
    public String codeGeneration()
    {
        return null;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        //TODO: controllare che non vengano ridefiniti i simboli della superclasse
        //TODO: aggiungere questa classe e il suo nome/simbolo all'environment
        return null;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
