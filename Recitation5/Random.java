import java.io.*;
import java.util.*;

public class Random {
    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation5/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String input = br.readLine();
        long a = Long.parseLong(input.split(" ")[0]);
        long b = Long.parseLong(input.split(" ")[1]);
        long mod = Long.parseLong(input.split(" ")[2]);
        int k = Integer.parseInt(input.split(" ")[3]);
        System.out.println(findSmallest(a, b, mod, k));
    }

    static long[] array = new long[5000000];

    static void randomize(long a, long b, long mod) {
        for (int i = 0; i < 5000000; i++) {
            a = 31014 * (a & 65535) + (a >> 16);
            b = 17508 * (b & 65535) + (b >> 16);
            array[i] = ((a << 16) + b) % mod;
        }
    }

    static long findSmallest(long a, long b, long mod, int k) {
        randomize(a, b, mod);
        Arrays.sort(array);
        return array[k];
    }

}