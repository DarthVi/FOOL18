package unitTestCovella;

import visitors.FOOLVisitorImpl;
import visitors.FunctionVisitor;
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
    private Environment environment;

    public INode buildAST(String code) throws LexerException, ParserException, SemanticException
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

        //building AST

        //1st pass to get function definition
        FunctionVisitor funVisitor = new FunctionVisitor();
        funVisitor.visit(progContext);

        //we do a little bit of semantic analysis even here, considering however
        //only function definitions
        if(funVisitor.getErrorsSize() > 0)
            throw new SemanticException(funVisitor.getErrors());

        environment = funVisitor.getEnvironment();

        //2nd pass
        FOOLVisitorImpl visitor = new FOOLVisitorImpl();

        return (INode) visitor.visit(progContext);
    }

    public ArrayList<SemanticError> checkSemantics(INode node, Environment env) throws SemanticException
    {
        ArrayList<SemanticError> errors = node.checkSemantics(environment);

        if (errors.size() > 0)
            throw new SemanticException(errors);

        return errors;
    }

    public IType typeCheck(INode node) throws TypeException
    {
        return node.typeCheck();
    }

    public Environment getEnvironment()
    {
        return environment;
    }
}
