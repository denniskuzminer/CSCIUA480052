import java.io.*;
import java.util.*;

public class RPN {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS4/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String input = "";
        String st = "";
        for (; (st = br.readLine()) != null;) {
            input += st;
        }
        System.out.println(infixToRPN(String.join("", input.split("\n"))));
    }

    // This solution is based mainly off the pseudocode and code in
    // https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
    // as well as the methodology in
    // https://www.web4college.com/converters/infix-to-postfix-prefix.php
    public static String infixToRPN(String str) {
        Stack<Character> output = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                output.push(ch);
            } else if (ch == '(') {
                operator.push(ch);
            } else if (ch == ')') {
                while (!operator.isEmpty() && operator.peek() != '(')
                    output.push(operator.pop());
                operator.pop();
            } else {
                while (!operator.isEmpty() && precedence(ch) <= precedence(operator.peek())) {

                    output.push(operator.pop());
                }
                operator.push(ch);
            }

        }
        while (!operator.isEmpty()) {
            if (operator.peek() == '(')
                return "-1";
            output.push(operator.pop());
        }
        return output.toString().replace(", ", "").replace("[", "").replace("]", "");
    }

    public static int precedence(char c) {
        if (c == '+' || c == '-')
            return 1;
        if (c == '*' || c == '/')
            return 2;
        return -1;
    }

}