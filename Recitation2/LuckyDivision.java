import java.io.*;
import java.util.*;

public class LuckyDivision {
    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation2/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        System.out.println(isAlmostLucky(Integer.parseInt(st)) ? "YES" : "NO");
    }

    public static boolean isAlmostLucky(int num) {
        int[] luckyNums = new int[] { 4, 7, 44, 77, 47, 74, 444, 447, 477, 474, 777, 747, 744, 774 };
        for (int i = 0; i < luckyNums.length; i++) {
            if (num % luckyNums[i] == 0)
                return true;
        }
        return false;
    }
}
