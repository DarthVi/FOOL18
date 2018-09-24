package ast;

import exception.TypeException;
import parser.FOOLParser;
import type.IType;
import type.IntType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class IntNode implements INode {

  private Integer val;
  private FOOLParser.IntValContext ctx;
  
  public IntNode(Integer n, FOOLParser.IntValContext ctx) {
      val=n;
      this.ctx = ctx;
      if((ctx.getChild(0).toString().equalsIgnoreCase( "-"))) val=-val;         //if int value is preceded by "-"
  }

  @Override
  public String toString() {
    return "Int: " + Integer.toString(val) +"\n";
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