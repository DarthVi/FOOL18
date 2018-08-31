package ast;

import exception.TypeException;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public interface INode {

    String codeGeneration();

}
