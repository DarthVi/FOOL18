package ast;

import parser.FOOLParser;
import type.BoolType;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class BoolNode implements INode {

  private boolean val;
  private FOOLParser.BoolValContext ctx;

    public BoolNode(boolean n, FOOLParser.BoolValContext ctx) {
        val=n;
        this.ctx = ctx;
        if((ctx.getChild(0).toString().equalsIgnoreCase( "not"))) val = !val;

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
  
  public String codeGeneration()


        {
      return "push "+(val?1:0)+"\n";
	  }
         
}  