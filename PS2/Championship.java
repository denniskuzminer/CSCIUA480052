import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Championship {

    public static void main(String args[]) throws Exception {

        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS2/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int numPlayers = (int) Math.pow(2, Integer.parseInt(st.split(" ")[0]));
        boolean noAbs = 0 == (int) Integer.parseInt(st.split(" ")[1]);
        if (noAbs) {
            System.out.print("0");
        } else {
            st = br.readLine();
            int[] absent = Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).toArray();
            // System.out.println(numPlayers + "\n" + Arrays.toString(absent));
            System.out.print(countWalks(numPlayers, absent));
        }
    }

    public static int countWalks(int numPlayers, int[] absent) {
        int walks = 0;
        List<Integer> list = Arrays.stream(absent).boxed().collect(Collectors.toList());
        boolean[] tree = new boolean[(2 * numPlayers) - 1];
        for (int i = numPlayers - 1, j = 1; i < tree.length; i++, j++) {
            tree[i] = !(list.contains(j));
        }
        // System.out.println(Arrays.toString(tree));
        for (int j = (int) (Math.log(tree.length) / Math.log(2)); j > 0; j--) {
            for (int i = (int) Math.pow(2, j) - 1 /* numPlayers - 1 */; i < /* tree.length */(int) Math.pow(2, j + 1)
                    - 1; i += 2) {
                // System.out.println(i + " " + (tree[i] || tree[i + 1]) + " " + (i - 2) / 2);
                tree[(i - 1) / 2] = tree[i] || tree[i + 1];
                if (tree[i] ^ tree[i + 1])
                    walks++;
            }
        }
        // System.out.println(Arrays.toString(tree) + " " + walks);
        return walks;
    }
}
