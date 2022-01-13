import java.io.*;
import java.util.*;

public class Dinner {
    public static void main(String args[]) throws Exception {
        String input = "";
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation3/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        input = st;
        int row = Integer.parseInt(input.split(" ")[0]);
        int col = Integer.parseInt(input.split(" ")[1]);
        int[][] arr = new int[row][col];
        for (int i = 0; i < row && ((st = br.readLine()) != null); i++)
            for (int j = 0; j < col; j++)
                arr[i][j] = Integer.parseInt(st.split(" ")[j]);
        System.out.println(bestDinner(arr));
    }

    public static int bestDinner(int[][] arr) {
        int emma = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = min(arr[i]);
            if (min > emma)
                emma = i;
        }
        return min(arr[emma]);
    }

    static int min(int arr[]) {
        int res = arr[0];

        for (int i = 1; i < arr.length; i++)
            res = Math.min(res, arr[i]);
        return res;
    }

}