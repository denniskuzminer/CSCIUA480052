import java.io.*;
import java.util.*;

public class Rod {
    public static void main(String args[]) throws Exception {
        String input = "";
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS1/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        input = st;
        System.out.println(findOrientation());
    }

    public static String findOrientation() {
        return "0";
    }

}