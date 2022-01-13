import java.io.*;
import java.util.*;

public class Candies {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS6/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        System.out.println(minMoves(arr));
    }

    public static String minMoves(long[] arr) {
        long min = Long.MAX_VALUE;
        String minStr = "";
        Integer[][] combos = { { 2, 4, 6 }, { 2, 3, 7 }, { 0, 4, 8 }, { 0, 5, 7 }, { 1, 3, 8 }, { 1, 5, 6 } };
        String[] comboStrings = { "CGB", "CBG", "BGC", "BCG", "GBC", "GCB" };
        long temp = 0;
        for (int i = 0; i < combos.length; i++, temp = 0) {
            for (int j = 0; j < arr.length; j++) {
                if (!Arrays.asList(combos[i]).contains(j)) {
                    temp += arr[j];
                }
            }
            if (temp < min) {
                min = temp;
                minStr = comboStrings[i];
            }
            if (temp == min) {
                minStr = comboStrings[i].compareTo(minStr) < 0 ? comboStrings[i] : minStr;
            }
        }
        return minStr + " " + min;
    }
}