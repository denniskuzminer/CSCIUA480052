
import java.io.*;
import java.util.*;

public class Knight {
    static int[][] board;

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS10/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int R = Integer.parseInt(st.split(" ")[0]);
        int C = Integer.parseInt(st.split(" ")[1]);
        int M = Integer.parseInt(st.split(" ")[2]);
        int N = Integer.parseInt(st.split(" ")[3]);
        board = new int[R][C];
        for (int[] row : board)
            Arrays.fill(row, -1);
        br.readLine();
        for (int i = 0; ((st = br.readLine()) != null); i++)
            board[Integer.parseInt(st.split(" ")[0]) - 1][Integer.parseInt(st.split(" ")[1]) - 1] = -2;
        System.out.println(findEvenOdd(M, N));
    }

    public static String findEvenOdd(int M, int N) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != -2) {
                    int count = find(i, j, M, N);
                    if (count != 0) {
                        if (count % 2 == 0) {
                            even++;
                        } else {
                            odd++;
                        }
                    }
                }
            }
        }

        // System.out.println(findAndMark(0, 0, M, N, 0));
        // System.out.println(Arrays.deepToString(board));
        return even + " " + odd;
    }

    public static int find(int i, int j, int M, int N) {
        int count = 0;
        if (checkSquare(i, j, M, N)) {
            count++;
        }
        if (checkSquare(i, j, M, -N)) {
            count++;
        }
        if (checkSquare(i, j, -M, N)) {
            count++;
        }
        if (checkSquare(i, j, -M, -N)) {
            count++;
        }
        if (checkSquare(i, j, N, M)) {
            count++;
        }
        if (checkSquare(i, j, N, -M)) {
            count++;
        }
        if (checkSquare(i, j, -N, M)) {
            count++;
        }
        if (checkSquare(i, j, -N, -M)) {
            count++;
        }

        return count;
    }

    public static boolean checkSquare(int i, int j, int iOffSet, int jOffSet) {
        return ((i + iOffSet) >= 0 && (i + iOffSet) < board.length)
                && ((j + jOffSet) >= 0 && (j + jOffSet) < board[0].length) && board[i + iOffSet][j + jOffSet] != -2;
    }
}
