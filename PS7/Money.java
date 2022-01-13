import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Money {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS7/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String inputStr = br.readLine();
        double input = Double.parseDouble(inputStr);
        System.out.println(findWays(input, inputStr));
    }

    public static String findWays(double input, String inputStr) {
        int target = (int) Math.round(input * (double) 100);
        int[] ans = new int[target + 1];
        ans[0] = 1;
        int[] coins = { 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000 };
        BigInteger[][] coinsByTarget = new BigInteger[coins.length + 1][target + 1];
        if (target % 5 == 0) {
            Arrays.fill(coinsByTarget[0], BigInteger.valueOf(0));
            for (int i = 0; i <= coins.length; i++) {
                coinsByTarget[i][0] = BigInteger.valueOf(1);
            }
            for (int i = 1; i <= coins.length; i++) {
                for (int j = 1; j <= target; j++) {
                    if (coins[i - 1] > j) {
                        coinsByTarget[i][j] = coinsByTarget[i - 1][j];
                    } else {
                        coinsByTarget[i][j] = coinsByTarget[i - 1][j].add(coinsByTarget[i][j - coins[i - 1]]);
                    }
                }
            }
        }
        String ret = "";
        for (int i = 0; i < 6 - (inputStr).length(); i++) {
            ret += " ";
        }
        ret += inputStr;
        if (target % 5 == 0) {
            for (int i = 0; i < 17 - (coinsByTarget[coins.length][target] + "").length(); i++) {
                ret += " ";
            }
            ret += coinsByTarget[coins.length][target] + "";
        } else {
            for (int i = 0; i < 17 - (0 + "").length(); i++) {
                ret += " ";
            }
            ret += 0 + "";
        }
        return ret;
    }
}