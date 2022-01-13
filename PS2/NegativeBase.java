import java.io.*;
import java.util.*;

public class NegativeBase {

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS2/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        System.out.print(convert(Integer.parseInt(st)));
    }

    public static String convert(int num) {
        int init = num;
        String output = "";
        ArrayList<Long> arr = new ArrayList<Long>();
        long remainder = 0;
        while (num != 0) {
            remainder = num % -2;
            // System.out.println(numToConvert + " " + remainder);
            num /= -2;
            if (remainder < 0) {
                remainder += 2;
                num++;
            }
            arr.add(new Long(remainder));
        }
        Collections.reverse(arr);

        for (Long digit : arr) {
            output += digit;
        }
        return output.equals("") ? "0" : output;
    }
}
