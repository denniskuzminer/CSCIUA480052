import java.io.*;
import java.util.*;

public class E {

    static Set<String> ans = new TreeSet<String>();

    public static void main(String args[]) throws Exception {

        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Midterm/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String input = "";
        String st = br.readLine();
        // int numLoops = Integer.parseInt(br.readLine());
        // for (int i = 0; i < numLoops && ((st = br.readLine()) != null); i++) {
        int n = Integer.parseInt(st.split(" ")[0]);
        int r = Integer.parseInt(st.split(" ")[1]);
        combinations(n, r);
        System.out.println(ans.toString().replace(", ", "\n").replace("[", "").replace(" ]", ""));
        // printPermutn(s, "");
        // input += st + " ";
        // }
        // int[] arr = Arrays.stream(br.readLine().split("
        // ")).mapToInt(Integer::parseInt).toArray();
    }

    public static String combinations(int n, int r) {
        String start = "";
        for (int i = 0; i < n - r; i++) {
            start += "0";
        }
        for (int i = 0; i < r; i++) {
            start += "1";
        }
        // combo(r, n, 0, start, "", n - 1, 0);
        // combo(start, n, r, 0, 0, "");
        combo(start, "");
        return "";
    }

    static void combo(String start, String curr) {
        if (start.length() == 0) {
            ans.add(curr + " ");
            return;
        }
        for (int i = 0; i < start.length(); i++) {
            char currChar = start.charAt(i);
            String split = start.substring(0, i) + start.substring(i + 1);
            combo(split, curr + currChar);
        }
    }

    // public static void combo(String a, int n, int r, int i, int sum, String curr)
    // {
    // if (i == n) {
    // if (sum == r) {
    // ans.add(curr);
    // }
    // return;
    // }
    // combo(a, n, r, i + 1, sum + a.charAt(i), curr + "" + a.charAt(i));
    // combo(a, n, r, i + 1, sum, curr);
    // }

}