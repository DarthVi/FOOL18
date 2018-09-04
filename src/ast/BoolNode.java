package ast;

import type.BoolType;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class BoolNode implements INode {

  private boolean val;
  
  public BoolNode(boolean n) {
    val=n;
  }

  @Override
  public String toString() {
    if (val) return "Bool:true\n";
    else return "Bool:false\n";
  }
  
  public IType typeCheck() {
    return new BoolType();
  }    
  
  @Override
 	public ArrayList<SemanticError> checkSemantics(Environment env) {
 	  return new ArrayList<SemanticError>();
 	}
  
  public String codeGeneration() {
		return "push "+(val?1:0)+"\n";
	  }
         
}  