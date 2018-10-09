package lib;

import ast.*;

public class FOOLlib {

    private static int labCount=0;
    private static int funLabCount=0;
    private static String funCode="";
    private static int numberDeclarations = 0;

    public static int getNumberDeclarations() {
        return numberDeclarations;
    }

    public static void increaseNumberDeclaration() {
        numberDeclarations++;
    }

    public static String freshLabel() {
        return "label"+(labCount++);
    }

    public static String freshFunLabel() {
        return "function"+(funLabCount++);
    }

    public static String getCode() {
        return funCode;
    }

    public static void insertfun(String c) { funCode += "\n" + c; }

    public static String getfun() {
        return funCode;
    }



}
