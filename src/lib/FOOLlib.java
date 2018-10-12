package lib;

import ast.*;

import java.util.HashMap;

public class FOOLlib {

    private static int labCount=0;
    private static int funLabCount=0;
    private static String funCode="";

    public static String freshLabel() {
        return "label"+(labCount++);
    }

    public static String freshFunLabel() {
        return "function"+(funLabCount++);
    }

    public static String getCode() {
        return funCode;
    }

    public static void insertfun(String c) {
        int indexofColon = c.indexOf(":");
        String label = c.substring(0, indexofColon);

        if(!label.equals("function" + funLabCount))
            funCode += "\n" + c;
    }

    public static void resetFOOLlib() {
        labCount=0;
        funLabCount=0;
        funCode="";
    }

    public static String getfun() {
        return funCode;
    }
}
