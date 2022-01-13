import java.io.*;
import java.util.*;

public class Prime {

    static List<Integer> perms = new ArrayList<Integer>();

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Final/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(br.readLine());
        int nextPow = getNextPow10(n);
        List<Integer> primeNumbers = sieveOfEratosthenes(getNextPow10(n));
        Set<Integer> nums = new HashSet<Integer>(primeNumbers);
        for (Integer primeNumber : primeNumbers) {
            if (primeNumber > n && primeNumber < nextPow) {
                printPermutn(primeNumber + "", "");
                boolean possibleAns = true;
                for (Integer perm : perms) {
                    possibleAns = nums.contains(perm) && possibleAns;
                }
                if (possibleAns) {
                    System.out.println(primeNumber);
                    return;
                }
                perms.clear();
            }
        }
        System.out.println(0);
    }

    public static List<Integer> sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    public static int getNextPow10(int n) {
        for (int exp = 0, curr = 10; curr < 10000000; exp++) {
            if (Math.pow(curr, exp) > n) {
                return (int) Math.round(Math.pow(curr, exp));
            }
        }
        return 1;
    }

    static void printPermutn(String str, String ans) {
        if (str.length() == 0) {
            perms.add(Integer.parseInt(ans));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            printPermutn(ros, ans + ch);
        }
    }
}