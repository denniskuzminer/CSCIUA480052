import java.io.*;
import java.util.*;

public class Counter {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS8/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        long count = 0;
        for (var str : br.readLine().replaceAll("[^a-zA-Z]", " ").split(" ")) {
            count += !str.trim().equals("") ? 1 : 0;
        }
        System.out.println(count);
    }
}