import java.io.*;
import java.util.*;

public class Word {
    public static void main(String args[]) throws Exception {
        String input = "";
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation3/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        input = st;
        System.out.println(correctWord(input));
    }

    public static String correctWord(String input) {
        int countUpper = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.toUpperCase(input.charAt(i)) == input.charAt(i)) {
                countUpper++;
            }
        }
        if (input.length() - countUpper < countUpper) {
            return input.toUpperCase();
        }
        if (input.length() - countUpper > countUpper || input.length() - countUpper == countUpper) {
            return input.toLowerCase();
        }

        return "0";
    }

}