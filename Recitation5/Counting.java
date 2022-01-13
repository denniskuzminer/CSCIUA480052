import java.io.*;
import java.util.*;

public class Counting {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp
        // Sci/CSCIUA480052/Recitation5/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String input = "";

        int numLoops = Integer.parseInt(br.readLine());
        input += br.readLine();

        int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(count(arr, numLoops));

    }

    public static String count(int[] arr, int upper) {
        int[] ans = new int[upper];
        Arrays.fill(ans, 0);
        for (int i : arr) {
            ans[i]++;
        }
        return Arrays.toString(ans).replace(",", "").replace("[", "").replace("]", "");
    }

}