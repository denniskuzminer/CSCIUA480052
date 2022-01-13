
// This solution uses aspects of the solution in https://cs.nyu.edu/courses/summer13/CSCI-UA.0380-001//class/2013/07/25/class-06-dynamic-programming.html
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int memo[][] = new int[210][30];

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS8/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int M = Integer.parseInt(st.split(" ")[0]);
        int K = Integer.parseInt(st.split(" ")[1]);
        List<List<Integer>> prices = new ArrayList<List<Integer>>();
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            List<Integer> nums = Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).boxed()
                    .collect(Collectors.toList());
            List<Integer> newNums = nums.subList(1, nums.size());
            prices.add(newNums);
        }
        Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, -1));
        int ans;
        System.out.println((ans = findMaxPrice(M, M, prices, 0)) < 0 ? "no solution" : ans);
    }

    public static int findMaxPrice(int M, int currM, List<List<Integer>> prices, int i) {
        if (currM < 0) {
            return -1;
        } else {
            if (i == prices.size()) {
                return M - currM;
            } else {
                if (memo[currM][i] > -1) {
                    return memo[currM][i];
                } else {
                    int ans = -1;
                    for (int j = 0; j < prices.get(i).size() && prices.get(i).get(j) >= 0; j++) {
                        ans = Math.max(ans, findMaxPrice(M, currM - prices.get(i).get(j), prices, i + 1));
                    }
                    return memo[currM][i] = ans;
                }
            }
        }
    }
}
