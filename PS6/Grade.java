import java.io.*;
import java.util.*;

public class Grade {

    static BufferedWriter output;

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS6/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        output = new BufferedWriter(new OutputStreamWriter(System.out, "ASCII"), 4096);
        // BufferedReader br = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        sorted(a);
        output.flush();
    }

    public static void sorted(int[] arr) throws IOException {
        int[] count = new int[101];
        int max = -1;
        for (int num : arr) {
            count[num]++;
            if (num > max)
                max = num;
        }
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                output.write((i == max && j == count[i] - 1) ? i + "" : i + " ");
            }
        }
        output.write("\n");
    }
}