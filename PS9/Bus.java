import java.io.*;
import java.util.*;

public class Bus {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS9/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = "";
        int[] scores = new int[Integer.parseInt(br.readLine()) - 1];
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            scores[i] = Integer.parseInt(st);
        }
        System.out.println(findNicest(scores));
    }

    public static String findNicest(int[] scores) {
        long max = Long.MIN_VALUE;
        int[] currSumIndices = new int[2];
        for (int i = 0; i < scores.length; i++) {
            long currSum = 0;
            int currSubList = 0;
            for (int j = i; j < scores.length; j++) {
                currSum += scores[j];
                currSubList++;
                if (currSum > max) {
                    max = currSum;
                    currSumIndices[0] = (i + 1);
                    currSumIndices[1] = (i + 1 + currSubList);
                }
                if (currSum == max) {
                    int oldDist = currSumIndices[1] - currSumIndices[0];
                    int newDist = (i + 1 + currSubList) - (i + 1);
                    if (newDist != oldDist && newDist > oldDist) {
                        currSumIndices[0] = (i + 1);
                        currSumIndices[1] = (i + 1 + currSubList);
                    }
                }
            }
        }
        if (max < 0) {
            return "Yet another overrated tourist destination";
        }
        return "The nicest part of Y1 is between stops " + currSumIndices[0] + " and " + currSumIndices[1];
    }
}