import java.io.*;
import java.util.*;

public class Knapsack {

    static ArrayList<Integer> ans = new ArrayList<Integer>();
    static int[][] dp;

    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation8/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int capacity = Integer.parseInt(st.split(" ")[0]);
        int numItems = Integer.parseInt(st.split(" ")[1]);
        dp = new int[numItems + 1][1 + capacity];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int[][] items = new int[numItems][2];
        for (int i = 0; i < numItems && ((st = br.readLine()) != null); i++) {
            items[i][0] = Integer.parseInt(st.split(" ")[0]);
            items[i][1] = Integer.parseInt(st.split(" ")[1]);
        }
        // int[] arr = Arrays.stream(br.readLine().split("
        // ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(maxValue(0, items, capacity));
        System.out.println(Arrays.deepToString(dp));

    }

    public static int maxValue(int i, int[][] items, int capacity) {
        if (i == items.length - 1 || capacity == 0) {
            return 0;
        }
        if (dp[i][capacity] != -1) {
            return dp[i][capacity];
        }
        if (items[i + 1][0] > capacity) {
            return dp[i][capacity] = maxValue(i + 1, items, capacity);
        }
        return dp[i][capacity] = max(items[i + 1][0] + maxValue(i + 1, items, capacity - items[i][1]),
                maxValue(i + 1, items, capacity));
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}