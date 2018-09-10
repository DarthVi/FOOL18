package unitTestCovella;

import ast.FOOLVisitorImpl;
import ast.INode;
import exception.LexerException;
import exception.ParserException;
import exception.SemanticException;
import exception.TypeException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.FOOLLexer;
import parser.FOOLParser;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class MockCompilerSteps
{
    public static INode buildAST(String code) throws LexerException, ParserException
    {
        CharStream input = CharStreams.fromString(code);

        //LEXER
        FOOLLexer lexer = new FOOLLexer(input);
        if (lexer.errors.size() > 0)
            throw new LexerException(lexer.errors);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //PARSING - Syntax analysis
        FOOLParser parser = new FOOLParser(tokens);
        FOOLParser.ProgContext progContext = parser.prog();
        if (parser.getNumberOfSyntaxErrors() > 0)
            throw new ParserException("Errori rilevati: " + parser.getNumberOfSyntaxErrors() + "\n");

        //Semantic Analysis
        FOOLVisitorImpl visitor = new FOOLVisitorImpl();

        return (INode) visitor.visit(progContext);
    }

    public static ArrayList<SemanticError> checkSemantics(INode node, Environment env) throws SemanticException
    {
        ArrayList<SemanticError> errors = node.checkSemantics(env);

        if (errors.size() > 0)
            throw new SemanticException(errors);

        return errors;
    }

    public static IType typeCheck(INode node) throws TypeException
    {
        return node.typeCheck();
    }
}
