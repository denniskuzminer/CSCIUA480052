import java.io.*;
import java.util.*;

public class Main {

    static HashMap<String, Integer> perms = new HashMap<String, Integer>();

    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Final/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int A = Integer.parseInt(st.split(" ")[0]);
        int B = Integer.parseInt(st.split(" ")[1]);
        System.out.println(findDesolate1(A, B));
    }

    public static long findDesolate(int A, int B) {
        String start = "";
        for (int i = 0; i < A; i++, start += "1") {
        }
        for (int i = 0; i < B; i++, start += "0") {
        }
        printPermutn(start, "");
        int max = Integer.MIN_VALUE;
        for (Map.Entry mapElement : perms.entrySet()) {
            if ((Integer) mapElement.getValue() > max)
                max = (Integer) mapElement.getValue();
        }
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for (Map.Entry mapElement : perms.entrySet()) {
            // System.out.println(Long.parseLong(((String) mapElement.getKey()), 2));
            if ((Integer) mapElement.getValue() == max) {
                pq.add(Long.parseLong(((String) mapElement.getKey()), 2));
            }
        }
        return pq.peek();
    }

    static void printPermutn(String str, String ans) {
        if (str.length() == 0) {
            perms.put(ans, numAdj(ans));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            printPermutn(ros, ans + ch);
        }
    }

    static int numAdj(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr != '1') {
                continue;
            }
            if (i > 0) {
                if (str.charAt(i - 1) == '0') {
                    ans++;
                    continue;
                }
            }
            if (i < str.length() - 1) {
                if (str.charAt(i + 1) == '0') {
                    ans++;
                    continue;
                }
            }
        }
        return ans;
    }

    public static long findDesolate1(int A, int B) {
        String start = "";
        int sum = A + B;
        // for (int i = 0; i < A; i++, start += "1") {
        // }
        // for (int i = 0; i < B; i++, start += "0") {
        // }
        while (A > 0 || B > 0) {
            System.out.println(A + " " + B);
            if (A > 0 && B == 0) {
                start += "1";
                A--;
                continue;
            }
            if (A == 1) {
                start += "1";
                A--;
            } else {
                start += "101";
                A -= 2;
                B--;
            }
        }
        while (start.length() != sum) {
            start = start.replaceFirst("1", "");
        }
        System.out.println(start);
        return Long.parseLong(start, 2);
    }

}