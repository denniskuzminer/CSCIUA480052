import java.io.*;
import java.util.*;

public class Homework {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS7/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String input = "";
        String st = input;
        int sumA = 0;
        int sumB = 0;
        int min = Integer.MAX_VALUE;
        br.readLine();
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            sumA += Integer.parseInt(st.split(" ")[0]);
            int b = Integer.parseInt(st.split(" ")[1]);
            sumB += b;
            if (b < min) {
                min = b;
            }
        }
        System.out.println(sumA + min);
        // System.out.println((sumA + min) > sumB ? (sumA + min) : sumB);
    }
}