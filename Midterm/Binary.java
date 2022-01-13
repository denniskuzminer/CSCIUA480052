import java.io.*;
import java.util.*;

public class Binary {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp
        // Sci/CSCIUA480052/Midterm/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String input = "";
        String st = input;
        int n = Integer.parseInt(br.readLine());
        // for (int i = 0; ((st = br.readLine()) != null); i++) {
        // input += st + " ";
        // }
        // int[] arr = Arrays.stream(br.readLine().split("
        // ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(split1(n));
    }

    public static String split(int n) {
        String bin = Integer.toBinaryString(n);
        String aStr = "";
        String bStr = "";
        int numOnes = 0;
        boolean one = false;
        for (int i = 0, j = 0; i < bin.length(); i++, one = false) {
            if (bin.charAt(i) == '1') {
                one = true;
                if (numOnes % 2 == 1) {
                    aStr += "0";
                    bStr += bin.charAt(i);
                } else {
                    if (numOnes % 2 == 0) {
                        bStr += "0";
                        aStr += bin.charAt(i);
                    }
                }
                numOnes++;

            }
            if (!one) {
                aStr += "0";
                bStr += "0";
            }
        }
        return Integer.parseInt(aStr, 2) + " " + Integer.parseInt(bStr, 2);
    }

    public static String split1(int n) {

        int a = 0;
        int b = 0;
        int ones = 0;
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) > 0) {
                if (ones % 2 == 0)
                    a |= (1 << i);
                else
                    b |= (1 << i);
                ones++;
            }
        }
        return a + " " + b;
    }

}