import java.io.*;
import java.util.*;

public class Ayu {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS2/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(br.readLine());
        String st = br.readLine();
        int[] boxes = Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("The minimum number of moves is " + convert(n, boxes) + ".");
    }

    public static int convert(int n, int[] boxes) {
        double avg = Arrays.stream(boxes).average().getAsDouble();
        int[] diffs = new int[boxes.length];
        for (int i = 0; i < boxes.length; i++) {
            diffs[i] = (int) (boxes[i] - avg < 0 ? 0 : boxes[i] - avg);
        }
        return Arrays.stream(diffs).sum();
    }
}