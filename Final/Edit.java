import java.io.*;
import java.util.*;

public class Edit {
    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Final/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = "";
        int n = Integer.parseInt(br.readLine());
        String[] dict = new String[n];
        for (int i = 0; i < n && ((st = br.readLine()) != null); i++)
            dict[i] = st;
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; ((st = br.readLine()) != null); i++)
            System.out.println(
                    edit(st.split(" ")[0], st.split(" ")[1], st.split(" ")[0].length(), st.split(" ")[1].length()));
    }

    public static int edit(String from, String to, int i, int j) {
        if (i == -1 || j == -1) {
            return Integer.MAX_VALUE;
        }
        if (i == 0 || j == 0) {
            return 0;
        }
        return Math.min(edit(from, to, i, j - 1) + 1,
                Math.min(edit(from, to, i - 1, j) + 1, edit(from, to, i - 1, j - 1) + cost(from, to, i - 1, j - 1)));
    }

    public static int cost(String from, String to, int i, int j) {
        return from.charAt(i) == to.charAt(j) ? 0 : 1;
    }
}