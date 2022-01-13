import java.io.*;
import java.util.*;

public class Labor {
    public static void main(String args[]) throws Exception {
        String input = "";
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS3/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int numDays = Integer.parseInt(st);
        st = br.readLine();
        int numLoops = Integer.parseInt(st);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < numLoops && ((st = br.readLine()) != null); i++) {
            arr.add(Integer.parseInt(st));
        }
        int strikes = numStrikes(numDays, arr.stream().mapToInt(Integer::intValue).toArray());
        System.out.println(strikes);
    }

    public static int numStrikes(int numDays, int[] input) {
        boolean[] arr = new boolean[numDays];
        Arrays.fill(arr, true);
        // System.out.println(numDays);
        // System.out.println(Arrays.toString(input));
        for (int i : input) {
            for (int j = i; j <= numDays; j += i) {
                if (!(j % 7 == 0 || j % 7 == 6)) {
                    // System.out.println(i + " " + j);
                    // System.out.println(j);
                    arr[j - 1] = false;
                }

            }
        }

        arr[0] = true;
        // System.out.println(Arrays.toString(arr));
        int ans = 0;
        for (boolean i : arr) {
            if (!i) {
                ans++;
            }
        }
        return ans;

    }
}