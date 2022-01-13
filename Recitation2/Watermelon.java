import java.io.*;
import java.util.*;

public class Watermelon {
    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation2/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        System.out.println(canDivide(Integer.parseInt(st)) ? "YES" : "NO");
    }

    public static boolean canDivide(int size) {
        return size % 4 == 0;
    }
}
