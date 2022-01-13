import java.io.*;
import java.util.*;

public class Homer {
    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS6/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String input = "";
        String st = input;
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            System.out.println(function(Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).toArray()));
        }
    }

    public static String function(int[] input) {
        int a = input[0];
        int b = input[1];
        int c = input[2];
        int[] burgersByTimes = new int[c + 1];
        // Arrays.fill(burgersByTimes, -1);
        burgersByTimes[0] = 0;
        int tempa = 0;
        int tempb = 0;
        for (int i = 0; i <= c; i++) {
            if (!(i - a < 0)) {
                tempa = 1 + burgersByTimes[i - a];
            } else {
                tempa = 0;
            }
            if (!(i - b < 0)) {
                tempb = 1 + burgersByTimes[i - b];
            } else {
                tempb = 0;
            }
            burgersByTimes[i] = Math.max(tempa, tempb);
        }
        System.out.println(Arrays.toString(burgersByTimes));
        return burgersByTimes[c] + "";
    }
}