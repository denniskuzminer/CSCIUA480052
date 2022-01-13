import java.io.*;
import java.util.*;

public class NonZero {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp
        // Sci/CSCIUA480052/Recitation4/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String input = br.readLine();
        int numLoops = Integer.parseInt(input);
        for (int i = 0; i < numLoops; i++) {
            input = br.readLine();
            input = br.readLine();
            int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(maxMoves(arr));
        }

    }

    public static int maxMoves(int[] arr) {
        int moves = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] += 1;
                moves++;
            }
        }
        if (Arrays.stream(arr).sum() == 0)
            moves++;
        return moves;
    }

}