import java.io.*;
import java.util.*;

public class Sum {

    static Set<String> ans = new HashSet<String>();

    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation 6/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String input = "";
        String st = input;
        for (int i = 0; ((st = br.readLine()) != null); i++, ans.clear()) {
            int[] arr = Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).toArray();
            sum(Arrays.copyOfRange(arr, 2, 2 + arr[1]), arr[1], arr[0], 0, 0, "");
            if (arr[1] != 0) {
                List<String> s = new ArrayList<>(ans);
                Collections.sort(s, Collections.reverseOrder());
                System.out.println("Sums of " + arr[0] + ":");
                if (ans.isEmpty()) {
                    System.out.println("NONE");
                } else {
                    for (String sum : s) {
                        System.out.println(sum.substring(1));
                    }
                }
            }
        }

    }

    public static void sum(int[] a, int n, int t, int i, int sum, String curr) {
        if (i == n) {
            if (sum == t) {
                ans.add(curr);
            }
            return;
        }
        sum(a, n, t, i + 1, sum + a[i], curr + "+" + a[i]);
        sum(a, n, t, i + 1, sum, curr);
    }
}