import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MiddleToEnd {

    public static void main(String[] args) {
        String expression = "1 + ( ( 2 + 3 ) * 4 ) - 5";

        List<String> infixExpressionList = toInfixExpression(expression);
        System.out.println(infixExpressionList);
        List<String> parseSuffixExpression = parseSuffixExpression(infixExpressionList);
        System.out.println(parseSuffixExpression);

        System.out.println(calculate(parseSuffixExpression));
    }

    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    public static List<String> toInfixExpression(String s) {
        String[] split = s.split(" ");
        List<String> list = new ArrayList<>();
        for (String string : split) {
            list.add(string);
        }
        return list;
    }

    public static List<String> parseSuffixExpression(List<String> ls) {
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();

        for (String item : ls) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }

        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num2 + num1;
                } else if (item.equals("-")) {
                    res = num2 - num1;
                } else if (item.equals("*")) {
                    res = num2 * num1;
                } else if (item.equals("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("Operator Error...");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int res = 0;
        switch (operation) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                break;
        }
        return res;
    }
}
