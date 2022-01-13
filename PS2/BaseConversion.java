import java.io.*;
import java.util.*;

public class BaseConversion {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS2/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        String[] input = st.split(" ");
        try {
            String converted = convert(Integer.parseInt(input[0]), Integer.parseInt(input[1]), input[2]);
            System.out.print(input[2] + " base " + input[0] + " = " + converted + " base " + input[1]);
        } catch (NumberFormatException ex) {
            System.out.print(input[2] + " is an illegal base " + input[0] + " number");
        }
    }

    public static String convert(int from, int to, String numToConvert) {
        long num;
        String[] split = ("" + numToConvert).split("");
        int[] to10 = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            int digit = 0;
            // System.out.println(split[i]);
            switch (split[i].charAt(0)) {
                case 'A':
                    digit = 10;
                    break;
                case 'B':
                    digit = 11;
                    break;
                case 'C':
                    digit = 12;
                    break;
                case 'D':
                    digit = 13;
                    break;
                case 'E':
                    digit = 14;
                    break;
                case 'F':
                    digit = 15;
                    break;
                default:
                    digit = Integer.parseInt(split[i]);
                    break;
            }

            to10[i] = digit;
        }
        // System.out.println(Arrays.toString(to10));
        // return 0;
        long base10 = 0;
        for (int i = 0, j = to10.length - 1; i < to10.length && j >= 0; i++, j--) {
            if (to10[i] >= from) {
                throw new NumberFormatException();
            }
            base10 += (to10[i] * Math.pow(from, j));
            // System.out.println(to10[i] + " " + from + " " + j + " " + (to10[i] *
            // Math.pow(from, j)) + " " + base10);
        }
        num = base10;
        ArrayList<Long> arr = new ArrayList<Long>();
        long remainder = 0;
        while (num > 0) {
            remainder = num % to;
            // System.out.println(numToConvert + " " + remainder);
            num /= to;

            arr.add(new Long(remainder));
        }
        Collections.reverse(arr);
        // System.out.println(arr.toString());

        String output = "";
        for (Long digit : arr) {
            if (digit < 10) {
                output += digit;
            } else {
                if (digit == 10) {
                    output += "A";
                } else if (digit == 11) {
                    output += "B";
                } else if (digit == 12) {
                    output += "C";
                } else if (digit == 13) {
                    output += "D";
                } else if (digit == 14) {
                    output += "E";
                } else if (digit == 15) {
                    output += "F";
                }
            }
        }
        return output.equals("") ? "0" : output;
    }
}
// public static String mapDigit(int digit) {
// switch (digit) {
// case 10:
// return 'A';
// case 11:
// return 'B';
// case 12:
// return 'C';
// case 13:
// return 'D';
// case 14:
// return 'E';
// case 15:
// return 'F';
// }
// return digit;
// }
