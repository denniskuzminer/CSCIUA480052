import java.io.*;
import java.util.*;

public class RabinKarp {
    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation9/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = "";
        String st1 = "";
        String st2 = "";
        for (int i = 0; (!(st = br.readLine()).equals("0 0")); i++) {
            st1 = br.readLine();
            st2 = br.readLine();
            System.out.println(RK(st1.replace(" ", ""), st2.replace(" ", "")));
        }
    }

    public static String RK(String st1, String st2) {
        var hp = hash(st2);
        for (int i = 0; i < (st1.length() - st2.length()); i++) {
            var ht = hash(st1.substring(i, i + st2.length()));
            if (hp == ht) {
                return "S";
            }
        }
        return "N";
    }

    public static long hash(String st) {
        long hash = 0;
        int A = 20;
        long M = Math.round(Math.pow(10, 9) + 7);
        char[] arr = st.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            hash += (Math.round(arr[i] * Math.pow(A, i)) % M);
        }
        return hash;
    }

    public static String[] transpose(String st) {
        return new String[1];
    }

    public static String convertSharpToFlat(String st) {
        return st.replace('#', 'b');
    }
}