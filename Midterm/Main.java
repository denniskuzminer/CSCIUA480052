import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp
        // Sci/CSCIUA480052/Midterm/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String input = "";
        String st = input;
        st = br.readLine();
        double n = Double.parseDouble(st.split(" ")[0]);
        double d = Double.parseDouble(st.split(" ")[1]);
        double[][] coord = new double[(int) n][2];
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            coord[i][0] = Double.parseDouble(st.split(" ")[0]);
            coord[i][1] = Double.parseDouble(st.split(" ")[1]);
        }
        // int[] arr = Arrays.stream(br.readLine().split("
        // ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(numSets(coord, n, d));
    }

    public static int numSets(double[][] coord, double n, double d) {
        int[] set = new int[(int) n];
        int numSets = 1;
        set[0] = 1;
        for (int i = 0; i < coord.length; i++) {
            for (int j = 0; j < coord.length; j++) {
                if (Math.hypot(coord[i][0] - coord[j][0], coord[i][1] - coord[j][1]) <= d) {
                    set[j] = set[i];
                } else {
                    numSets++;
                    set[i] = numSets;
                }
            }

        }
        return numSets;
    }
}