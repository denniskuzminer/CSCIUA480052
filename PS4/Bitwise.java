import java.io.*;
import java.util.*;

public class Bitwise {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        long N = Long.parseLong(input.split(" ")[0]);
        long L = Long.parseLong(input.split(" ")[1]);
        long R = Long.parseLong(input.split(" ")[2]);
        System.out.println(maximizeOR(N, L, R));
    }

    public static long maximizeOR(long N, long L, long R) {
        if (L == R) {
            return L;
        }
        String strN = decToBinary(N);
        String strL = decToBinary(L);
        String strR = decToBinary(R);
        String x = "00000000000000000000000000000000";
        for (int i = 31, j = 0; i >= 0; i--, j++) {
            if (binaryToDecimal(x) + Math.pow(2, i) - 1 < R) {
                x = x.substring(0, j) + "1" + x.substring(j + 1);
            }
            if (strN.charAt(j) == '1') {
                String altered = x.substring(0, j) + "0" + x.substring(j + 1);
                if (!(binaryToDecimal(altered) < L) || binaryToDecimal(x) - 1 >= L) {
                    x = altered;
                }
            }
        }
        return binaryToDecimal(x);
    }

    // This code was adapted from
    // https://www.geeksforgeeks.org/program-decimal-binary-conversion/
    public static String decToBinary(long n) {
        long[] binaryNum = new long[32];
        Arrays.fill(binaryNum, 0);
        int i = 0;
        while (n > 0) {
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }
        String binary = "";
        for (int j = 31; j >= 0; j--) {
            binary += "" + binaryNum[j];
        }
        return binary;
    }

    public static long binaryToDecimal(String n) {
        long num = 0;
        for (int i = 0, j = n.length() - 1; i < n.length() && j >= 0; i++, j--) {
            // System.out.println(Math.pow(2, j));
            if (n.charAt(i) == '1') {
                num += Math.pow(2, j);
            }
        }
        return num;
    }
}