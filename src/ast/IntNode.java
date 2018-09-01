package ast;

import exception.TypeException;
import type.IType;
import type.IntType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class IntNode implements INode {

  private Integer val;
  
  public IntNode(Integer n) {
    val=n;
  }

  @Override
  public String toString() {
    return "Int:" + Integer.toString(val) +"\n";
  }
  
  public IType typeCheck() throws TypeException
  {
    return new IntType();
  } 
  
  @Override
 	public ArrayList<SemanticError> checkSemantics(Environment env) {

 	  return new ArrayList<SemanticError>();
 	}
  
  public String codeGeneration() {
	return "push "+val+"\n";
  }

}  