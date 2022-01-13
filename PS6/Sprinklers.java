import java.io.*;
import java.util.*;

public class Sprinklers {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS6/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int[][] arr = new int[Integer.parseInt(st.split(" ")[0])][2];
        int len = Integer.parseInt(st.split(" ")[1]);
        int width = Integer.parseInt(st.split(" ")[2]);
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            arr[i][0] = Integer.parseInt(st.split(" ")[0]);
            arr[i][1] = Integer.parseInt(st.split(" ")[1]);
        }
        System.out.println(findMinSprinklers(arr, len, width));
    }

    public static int findMinSprinklers(int[][] arr, int len, int width) {
        int ans = 0;
        double currEdge = 0;
        int lastReach = 0;
        for (; currEdge < len; ans++) {
            for (int i = 0; i < arr.length; i++) {
                if (!(arr[i][1] * 2 < width)) {
                    if (arr[i][0] - arr[i][1]
                            - (arr[i][1] - (Math.sqrt(Math.pow(arr[i][1], 2) + Math.pow(width / 2, 2)))) < currEdge) {
                        if (arr[i][0] + arr[i][1] > lastReach) {
                            lastReach = arr[i][0] + arr[i][1];
                        }
                    }
                }
            }
            if (lastReach == currEdge) {
                return -1;
            } else {
                currEdge = lastReach;
            }
        }
        return ans;
    }
}