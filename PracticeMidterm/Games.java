import java.io.*;
import java.util.*;

public class Games {
    static Set<String> ans = new HashSet<String>();

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp
        // Sci/CSCIUA480052/PracticeMidterm/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sum(arr2, arr1[1], arr1[0], 0, 0, "");
        int opt = filter(ans, arr1[0]);
        System.out.println(opt);
    }

    public static int filter(Set<String> ans, int target) {
        int min = Integer.MAX_VALUE;
        for (String str : ans) {
            if (!str.equals("")) {
                int[] arr = Arrays.stream(str.substring(1).split(" ")).mapToInt(Integer::parseInt).toArray();
                int sum = Arrays.stream(arr).sum();
                if (target - sum < min && target - sum >= 0) {
                    min = target - sum;
                }
                // System.out.println(Arrays.toString(arr));
            }
        }
        return target - min;
    }

    public static void sum(int[] a, int n, int t, int i, int sum, String curr) {
        if (i == n) {
            if (sum <= t) {
                ans.add(curr);
            }
            return;
        }
        sum(a, n, t, i + 1, sum + a[i], curr + " " + a[i]);
        sum(a, n, t, i + 1, sum, curr);
    }
}