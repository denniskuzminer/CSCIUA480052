import java.io.*;
import java.util.*;
import java.util.Stack;
import java.util.stream.IntStream;

public class Train {
    public static void main(String args[]) throws Exception {
        String input = "";
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS3/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int n = Integer.parseInt(st);
        for (; ((st = br.readLine()) != null);) {
            if (!st.equals("0")) {
                System.out.println(
                        existsPermutation(n, Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).toArray()) ? "Yes"
                                : "No");
            }
        }
    }

    public static boolean existsPermutation(int n, int[] desired) {
        // System.out.println(Arrays.toString(desired));
        int[] cars = IntStream.range(1, n + 1).toArray();
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for (int i : cars) {
            stack.push(i);
            // System.out.println(stack.toString());
            while ((!stack.empty()) && desired[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        if (!stack.empty())
            return false;
        return true;
    }

}