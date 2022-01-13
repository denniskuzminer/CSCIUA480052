import java.io.*;
import java.util.*;

public class War {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS7/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));

        int[] soldiers = new int[Integer.parseInt(br.readLine().split(" ")[0]) + 1];
        soldiers[0] = -1;
        String st = "";
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            int L = Integer.parseInt(st.split(" ")[0]);
            int R = Integer.parseInt(st.split(" ")[1]);
            for (int j = L; j <= R; j++) {
                soldiers[j] = -1;
            }
            int leftMost;
            int rightMost;
            for (leftMost = L; (leftMost >= 0 && soldiers[leftMost] == -1); leftMost--) {
            }
            for (rightMost = R; (rightMost < soldiers.length && soldiers[rightMost] == -1); rightMost++) {
            }
            System.out.println(
                    (leftMost == -1 ? "*" : leftMost) + " " + (rightMost > (soldiers.length - 1) ? "*" : rightMost));
        }
    }
}