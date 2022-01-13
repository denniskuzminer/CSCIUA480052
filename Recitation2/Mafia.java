import java.io.*;
import java.util.*;

public class Mafia {
    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation2/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        input = br.readLine();
        int[] a = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(findNumRounds(n, a));
    }

    public static int findNumRounds(int n, int[] a) {
        // System.out.println(n + " " + Arrays.toString(a));
        int max = Arrays.stream(a).max().getAsInt();
        return max + 1;
    }
}