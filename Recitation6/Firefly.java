import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Firefly {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation
        // 6/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String input = "";
        String st = input;
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            input += st + " ";
        }
        int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(function(arr[0], arr[1], Arrays.copyOfRange(arr, 2, arr.length)));
    }

    public static String function(int n, int h, int[] obs) {
        int[] hitsE = new int[h];
        int[] hitsO = new int[h];
        for (int i = 0; i < obs.length; i++) {
            if (i % 2 == 0) {
                hitsE[obs[i] - 1]++;
            } else {
                hitsO[h - obs[i]]++;
            }
        }
        for (int i = h - 2, j = 1, e = 0, o = 0; i >= 0; i--, j++) {
            hitsE[i] += hitsE[i + 1];
            hitsO[j] += hitsO[j - 1];
            // prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        int[] ans = new int[h];
        for (int i = 0; i < h; i++) {
            ans[i] = hitsE[i] + hitsO[i];
        }
        // System.out.println(Arrays.toString(hitsE));
        // System.out.println(Arrays.toString(hitsO));
        // System.out.println(Arrays.toString(ans));
        Map<Integer, Long> freq = Arrays.stream(ans).boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        Integer key = Collections.min(freq.entrySet(), Map.Entry.comparingByKey()).getKey();
        return key + " " + freq.get(key);
    }
}
