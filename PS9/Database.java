import java.io.*;
import java.util.*;

public class Database {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS9/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String directions = br.readLine();
        br.readLine();
        int[] nums = Arrays.stream(br.readLine().replace("]", "").replace("[", "").split(","))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(getData(directions, nums));
    }

    public static String getData(String directions, int[] nums) {
        int front = 0, numRs = 0, end = nums.length - 1;
        for (int i = 0; i < directions.length(); i++) {
            if (directions.charAt(i) == 'R')
                numRs++;
            if (directions.charAt(i) == 'D')
                if ((numRs % 2) == 0)
                    front++;
                else
                    end--;
        }
        // System.out.println(front + " " + end);
        if ((front - end) == 1)
            return "[]";
        if (front > end)
            return "error";
        String ans = "";
        if ((numRs % 2) == 1)
            for (int i = end; i >= front; i--)
                ans += nums[i] + ",";
        else
            for (int i = front; i < 1 + end; i++)
                ans += nums[i] + ",";
        return "[" + ans.substring(0, ans.length() - 1) + "]";
    }
}