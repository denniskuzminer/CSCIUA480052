import java.io.*;
import java.util.*;

class Chef {
    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS9/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            br.readLine();
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(printFinalArray(arr));

        }
    }

    public static String printFinalArray(int[] arr) {
        int[] b = new int[arr.length];
        b[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (i != arr.length - 1 && arr[i] < arr[i + 1]) {
                return "-1";
            }
            b[i] = b[i - 1];
        }
        return "input";
    }

    public static String printFinalArray1(int[] arr) {
        String ans = "" + arr[0];
        for (int i = 1; i < arr.length; i++) {
            if ((i != arr.length - 1 && arr[i] < arr[i + 1]) || arr[i + 1] % arr[i] != 0) {
                return "-1";
            }
            ans += arr[i];
        }
        return ans;
    }
}