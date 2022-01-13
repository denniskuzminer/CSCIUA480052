import java.io.*;
import java.util.*;

public class Prize {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS5/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String input = "";
        String st = input;
        br.readLine();
        int ans = 0;
        ArrayList<Integer> orders = new ArrayList<Integer>();
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            if (Integer.parseInt(st.split(" ")[0]) != 0) {
                int[] arr = Arrays.copyOfRange(Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).toArray(), 1,
                        1 + Integer.parseInt(st.split(" ")[0]));
                // System.out.println(Arrays.toString(arr));
                for (int j : arr) {
                    orders.add(j);
                }
                Collections.sort(orders);
            }
            ArrayDeque<Integer> deq = new ArrayDeque<>(orders);
            // System.out.println(deq.toString());
            ans += (deq.removeLast() - deq.removeFirst());
            orders.clear();
            for (int j : deq) {
                orders.add(j);
            }
        }
        System.out.println(ans);

        // int[] arr = Arrays.stream(br.readLine().split("
        // ")).mapToInt(Integer::parseInt).toArray();
        // System.out.println(function(input));
    }

    public static String function(String input) {
        return input;
    }
}