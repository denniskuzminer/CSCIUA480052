
// This code uses https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
import java.io.*;
import java.util.*;

public class Blocks {

    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS11/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] nums = new int[num];
        String st = "";
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            nums[i] = Integer.parseInt(st);
        }
        int diff = findMin(nums, num);
        int sum = Arrays.stream(nums).sum();
        System.out.println((sum - diff) / 2 + " " + (sum + diff) / 2);

    }

    static int findMin(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j)
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
            }
        }
        int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j] == true) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }
}