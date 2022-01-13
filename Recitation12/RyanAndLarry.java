import java.io.*;
import java.util.*;

public class RyanAndLarry {
    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation12/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int N = Integer.parseInt(st.split(" ")[0]);
        int K = Integer.parseInt(st.split(" ")[1]);
        System.out.println(ways(N, K));
    }

    public static String ways(int N, int K) {
        return "0";
    }
}