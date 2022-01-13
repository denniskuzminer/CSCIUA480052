import java.io.*;
import java.util.*;

public class Word {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS10/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st1 = "";
        String st2 = "";
        for (int i = 0; ((st1 = br.readLine()) != null); i++) {
            st2 = br.readLine();
            int[][] memo = new int[st1.length() + 1][st2.length() + 1];
            Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, -1));
            System.out.println(LCS(memo, st1, st2, st1.length(), st2.length()));
            // System.out.println(Arrays.deepToString(memo));
        }
    }

    public static int LCS(int[][] memo, String st1, String st2, int i, int j) {
        if (j == 0 || i == 0) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (st1.charAt(i - 1) == st2.charAt(j - 1)) {
            memo[i][j] = LCS(memo, st1, st2, i - 1, j - 1) + 1;
        } else {
            memo[i][j] = Math.max(LCS(memo, st1, st2, i - 1, j), LCS(memo, st1, st2, i, j - 1));
        }
        return memo[i][j];
    }
}