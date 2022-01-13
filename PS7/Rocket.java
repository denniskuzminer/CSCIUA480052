import java.io.*;
import java.util.*;

public class Rocket {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS7/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(br.readLine());
        int[] rungs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(minStrength(rungs));
    }

    public static int minStrength(int[] rungs) {
        int minStrength = rungs[0];
        for (int i = 0; i < rungs.length - 1; i++) {
            if ((rungs[i + 1] - rungs[i]) > minStrength - 1) {
                minStrength = (rungs[i + 1] - rungs[i]);
            }
        }
        return minStrength;
    }
}