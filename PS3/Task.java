import java.io.*;
import java.util.*;

public class Task {
    public static void main(String args[]) throws Exception {
        String input = "";
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS3/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        input = st;
        int notRepeat = Integer.parseInt(input.split(" ")[0]);
        int repeat = Integer.parseInt(input.split(" ")[1]);
        int[][] rangeNotRepeat = new int[notRepeat][2];
        int[][] rangeRepeat = new int[repeat][3];
        for (int i = 0; i < notRepeat && ((st = br.readLine()) != null); i++) {
            rangeNotRepeat[i][0] = Integer.parseInt(st.split(" ")[0]);
            rangeNotRepeat[i][1] = Integer.parseInt(st.split(" ")[1]);
        }
        for (int i = 0; i < repeat && ((st = br.readLine()) != null); i++) {
            rangeRepeat[i][0] = Integer.parseInt(st.split(" ")[0]);
            rangeRepeat[i][1] = Integer.parseInt(st.split(" ")[1]);
            rangeRepeat[i][2] = Integer.parseInt(st.split(" ")[2]);
        }
        // System.out.println(Arrays.deepToString(rangeNotRepeat));
        // System.out.println(Arrays.deepToString(rangeRepeat));
        System.out.println(existsConflict(rangeNotRepeat, rangeRepeat) ? "CONFLICT" : "NO CONFLICT");
    }

    public static boolean existsConflict(int[][] rangeNotRepeat, int[][] rangeRepeat) {
        boolean[] arr = new boolean[1000000];
        // System.out.println(arr[0]);
        for (int[] timeblock : rangeNotRepeat) {
            int start = timeblock[0];
            int end = timeblock[1];
            for (int i = start; i < end; i++) {
                if (!(i >= 1000000)) {
                    if (arr[i])
                        return true;
                    arr[i] = true;
                }
            }
        }
        for (int[] timeblock : rangeRepeat) {
            int start = timeblock[0];
            int end = timeblock[1];
            int interval = timeblock[2];
            for (int j = 0; j < arr.length; j += interval) {
                for (int i = start + j; i < end + j; i++) {
                    if (!(i >= 1000000)) {
                        if (arr[i])
                            return true;
                        arr[i] = true;
                    }
                }
            }
        }
        // for (int i = 0; i < 30; i++)
        // System.out.print(arr[i] + " ");
        return false;
    }
}