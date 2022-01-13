import java.io.*;
import java.util.*;

public class Keyboard {

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS5/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String input = br.readLine();
        System.out.print(getOutput(input));
    }

    public static String getOutput(String input) {
        Stack<Character> stack = new Stack<Character>();
        for (char ch : input.toCharArray()) {
            if (ch != '<') {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        return stack.toString().replace(", ", "").replace("[", "").replace("]", "");
    }
}