package lib;

import ast.*;

import java.util.HashMap;

public class FOOLlib {

    private static int labCount=0;
    private static int funLabCount=0;
    private static int methodLabCount = 0;
    private static String funCode="";

    public static String freshLabel() {
        return "label"+(labCount++);
    }

    public static String freshFunLabel() {
        return "function"+(funLabCount++);
    }

    public static String freshmethodLabel() {
        return "function"+(methodLabCount++);
    }

    public static String getCode() {
        return funCode;
    }

    public static void insertfun(String c) { funCode += "\n" + c; }

    public static String getfun() {
        return funCode;
    }
}
