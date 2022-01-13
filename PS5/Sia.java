import java.io.*;
import java.util.*;

public class Sia {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS5/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String input = "";
        String st = input;
        input = br.readLine();
        int[][] operations = new int[Integer.parseInt(input)][2];
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            operations[i][0] = Integer.parseInt(st.split(" ")[0]);
            operations[i][1] = Integer.parseInt(st.split(" ")[1]);
        }
        // int[] arr = Arrays.stream(br.readLine().split("
        // ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(checkStruct(operations));
    }

    public static String checkStruct(int[][] operations) {
        ArrayList<String> ans = new ArrayList<String>();
        ans.add("stack");
        ans.add("queue");
        ans.add("priority queue");
        Stack<Integer> stack = new Stack<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x, y) -> Integer.compare(y, x));

        for (int[] instruction : operations) {
            if (instruction[0] == 1) {
                stack.push(instruction[1]);
            }
            if (instruction[0] == 2) {
                if (stack.pop() != instruction[1]) {
                    ans.remove("stack");
                    break;
                }
            }
        }
        for (int[] instruction : operations) {
            if (instruction[0] == 1) {
                queue.add(instruction[1]);
            }
            if (instruction[0] == 2) {
                if (queue.peek() != instruction[1]) {
                    ans.remove("queue");
                    break;
                }
                queue.remove();
            }
        }
        for (int[] instruction : operations) {
            if (instruction[0] == 1) {
                pq.add(instruction[1]);
            }
            if (instruction[0] == 2) {
                if (pq.peek() != instruction[1]) {
                    ans.remove("priority queue");
                    break;
                }
                pq.remove();
            }
        }
        return ans.size() > 1 ? "not sure" : ans.size() == 0 ? "impossible" : ans.get(0);
    }
}