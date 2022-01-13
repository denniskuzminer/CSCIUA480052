import java.io.*;
import java.util.*;

public class Delivery {
    static TreeMap<Integer, String> solutions = new TreeMap<Integer, String>();

    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS8/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        int wt = Integer.parseInt(br.readLine().split(" ")[1]);
        arrange(wt, wt, Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(), 0, "$");
        System.out.print(solutions.lastEntry().getValue());
    }

    public static void arrange(int wt1, int wt2, int[] items, int i, String curr) {
        if (i >= items.length || ((wt1 - items[i] < 0) && (wt2 - items[i] < 0))) {
            solutions.put(i, curr.replace("$", i + ""));
            return;
        }
        if (!(wt1 - items[i] < 0))
            arrange(wt1 - items[i], wt2, items, i + 1, curr + "\n1st");
        if (!(wt2 - items[i] < 0))
            arrange(wt1, wt2 - items[i], items, i + 1, curr + "\n2nd");
    }
}