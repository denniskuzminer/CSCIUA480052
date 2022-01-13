import java.io.*;
import java.util.*;

public class CarValue {
    public static void main(String args[]) throws Exception {
        String input = "";
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS1/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        input = st;
        int numLoops = Integer.parseInt(input.split(" ")[3]);
        for (int i = 0; i < numLoops && ((st = br.readLine()) != null); i++) {
            input += "\n";
            input += st;
        }
        // System.out.println(input);
        int monthNum = findMonth(input);
        if (Integer.parseInt(input.split(" ")[0]) == 0)
            System.out.println("0 months");
        else
            System.out.println(monthNum == 1 ? monthNum + " month" : monthNum + " months");
    }

    public static int findMonth(String input) {
        String[] splitInput = input.split("\n");
        double[] firstLine = Arrays.stream(splitInput[0].split(" ")).mapToDouble(Double::parseDouble).toArray();
        double carValue = firstLine[2] + firstLine[1];
        double owes = firstLine[2];
        double payment = owes / firstLine[0];
        double percent = 1;
        int month = 0;
        int j = 1;
        for (int i = 0; i < firstLine[0]; i++) {
            percent = Double.parseDouble(splitInput[j].split(" ")[1]);
            carValue *= (1 - percent);
            if (month != 0)
                owes -= payment;
            if (owes < carValue) {
                return month;
            }
            if (j + 1 < splitInput.length && Double.parseDouble(splitInput[j + 1].split(" ")[0]) == i + 1) {
                j++;
            }
            month++;
        }
        return month + 1;
    }
}

// String input = "30 500.0 15000.0 3\n0 .10\n1 .03\n3 .002";
// 12 500.0 9999.99 2
// 0 .05
// 2 .1

// 60 2400.0 30000.0 3
// 0 .2
// 1 .05
// 12 .025

// String[] splitInput = input.split("\n");
// double[] firstLine = Arrays.stream(splitInput[0].split("
// ")).mapToDouble(Double::parseDouble).toArray();
// double carValue = firstLine[2] + firstLine[1];
// double owes = firstLine[2];
// double payment = owes / firstLine[0];
// double percent = 1;
// double[] diffs = new double[(int) firstLine[3]];
// // for (int i = 1; i < firstLine[3]; i++) {
// // double monthDiff = Double.parseDouble(splitInput[i + 1].split(" ")[0])
// // - Double.parseDouble(splitInput[i].split(" ")[0]);
// // diffs[i - 1] = monthDiff;
// // diffs[diffs.length - 1] = firstLine[0] - Double.parseDouble(splitInput[i +
// // 1].split(" ")[0]);
// // }
// // System.out.println(Arrays.toString(diffs));
// int month = 0;
// // for (int i = 0; i < firstLine[3]; i++) {
// // for (int j = 0; j < diffs[i]; j++) {
// // percent = Double.parseDouble(splitInput[i + 1].split(" ")[1]);
// // carValue *= (1 - percent);
// // if (month != 0)
// // owes -= payment;
// // // System.out.println("Month " + month + ": " + owes + " " + carValue + "
// " +
// // // percent);
// // if (owes < carValue) {
// // return month;
// // }
// // month++;
// // }
// // }
// int j = 1;
// for (int i = 0; i < firstLine[0]; i++) {
// percent = Double.parseDouble(splitInput[j].split(" ")[1]);
// carValue *= (1 - percent);
// if (month != 0)
// owes -= payment;
// // System.out.println("Month " + month + ": " + owes + " " + carValue + " " +
// // percent);
// if (owes < carValue) {
// return month;
// }
// if (j + 1 < splitInput.length && Double.parseDouble(splitInput[j + 1].split("
// ")[0]) == i + 1) {
// j++;
// }
// month++;

// }
// return month + 1;
// }