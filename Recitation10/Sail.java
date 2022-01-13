import java.io.*;
import java.util.*;

public class Sail {
    static TreeSet<Integer> ans = new TreeSet<Integer>();
    static int[] memo;

    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation10/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String directions = br.readLine();
        // System.out.println(Arrays.toString(arr) + " " + directions);
        memo = new int[directions.length()];
        Arrays.fill(memo, -1);
        System.out.println(findMinTime(arr[0], arr[1], arr[2], arr[3], arr[4], directions, 0, "$"));
        // System.out.println(ans.size() == 0 ? -1 : ans.first());
    }

    public static int findMinTime(int t, int sx, int sy, int ex, int ey, String directions, int currT, String curr) {
        if (sx == ex && sy == ey) {
            ans.add(currT);
            // System.out.println(curr);
            return currT;
        }
        if (currT == t) {
            return -1;
        }
        if (memo[currT] != -1) {
            return memo[currT];
        }
        // take the move
        memo[currT] = Math.min(
                findMinTime(t, directions.charAt(currT) == 'E' ? sx + 1 : directions.charAt(currT) == 'W' ? sx - 1 : sx,
                        directions.charAt(currT) == 'N' ? sy + 1 : directions.charAt(currT) == 'S' ? sy - 1 : sy, ex,
                        ey, directions, currT + 1, curr + "\n" + sx + " " + sy),
                findMinTime(t, sx, sy, ex, ey, directions, currT + 1, curr));
        // dont take the move

        return ans.size() == 0 ? -1 : ans.first();

    }
}