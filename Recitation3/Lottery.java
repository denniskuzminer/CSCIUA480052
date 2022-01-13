import java.io.*;
import java.util.*;

public class Lottery {
    public static void main(String args[]) throws Exception {
        String input = "";
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation3/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        input = st;
        System.out.println(minNumBills(Integer.parseInt(input)));
    }

    public static int minNumBills(int input) {
        int numBills = 0;
        while (input > 0) {
            if (input >= 100) {
                input -= 100;
                numBills++;
                continue;
            }
            if (input >= 20) {
                input -= 20;
                numBills++;
                continue;
            }
            if (input >= 10) {
                input -= 10;
                numBills++;
                continue;
            }
            if (input >= 5) {
                input -= 5;
                numBills++;
                continue;
            }
            if (input >= 1) {
                input -= 1;
                numBills++;
                continue;
            }
        }
        return numBills;
    }

}