import java.io.*;
import java.util.*;

public class Anton {
    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation4/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String input = br.readLine();
        int k2 = Integer.parseInt(input.split(" ")[0]);
        int k3 = Integer.parseInt(input.split(" ")[1]);
        int k5 = Integer.parseInt(input.split(" ")[2]);
        int k6 = Integer.parseInt(input.split(" ")[3]);
        System.out.println(maxSum(k2, k3, k5, k6));

    }

    public static int maxSum(int k2, int k3, int k5, int k6) {
        int sum = 0;
        for (; k2 > 0 && k5 > 0 && k6 > 0; k2--, k5--, k6--)
            sum += 256;
        for (; k3 > 0 && k2 > 0; k3--, k2--)
            sum += 32;
        return sum;
    }

}