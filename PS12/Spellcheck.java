// PRELIMINARY SOLUTION
// adapted from https://en.wikipedia.org/wiki/Needleman%E2%80%93Wunsch_algorithm

// notes
// 1. solution has not been tested on a wide variety of test cases
//    (mostly just the 2 example test cases in the problem prompt)
// 2. does not implement any specific tie-breaking rules,
//    just picks the first best match
// 3. currently prints out the dp[] array for each word in the dict...
//    the print line can be commented out

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Spellcheck {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = in.readLine();
        int n = Integer.parseInt(in.readLine());
        String[] dict = new String[n];
        for (int i = 0; i < n; ++i) {
            dict[i] = in.readLine();
        }

        String closestMatch = "";
        int closestMatchPenalty = Integer.MAX_VALUE;
        PriorityQueue<String> possibleMatches = new PriorityQueue<String>();

        for (String word : dict) {
            int penalty = needlemanWunsch(word, target);
            if (penalty == closestMatchPenalty) {
                possibleMatches.add(word);
            } else {
                if (penalty < closestMatchPenalty) {
                    closestMatch = word;
                    closestMatchPenalty = penalty;
                    possibleMatches.clear();
                    possibleMatches.add(word);
                }
            }
        }

        out.write(possibleMatches.peek() + "\n");
        out.flush();
    }

    private static int needlemanWunsch(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int col = 0; col < dp[0].length; ++col) {
            dp[0][col] = col * 1;
        }
        for (int row = 0; row < dp.length; ++row) {
            dp[row][0] = row * 1;
        }

        for (int i = 1; i < dp.length; ++i) {
            for (int j = 1; j < dp[0].length; ++j) {
                int delete = dp[i - 1][j] + 1;
                int insert = dp[i][j - 1] + 1;
                int match = a.charAt(i - 1) == b.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 2;

                dp[i][j] = Math.min(delete, Math.min(insert, match));
            }
        }

        return dp[a.length()][b.length()];
    }
}
