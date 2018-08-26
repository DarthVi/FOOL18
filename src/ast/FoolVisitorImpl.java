package ast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.antlr.v4.runtime.tree.ParseTree;
import util.SemanticError;
import  ast.*;


public class FoolVisitorImpl extends antlr.FOOLBaseVisitor<INode> {

    @Override
    public INode visit(ParseTree tree) {
        INode res=new  BoolNode(true);
        return res;
    }

    // TO DO
}

