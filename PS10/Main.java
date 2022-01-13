// This code was written with the help of Brian Guo

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS10/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int r = Integer.parseInt(st.split(" ")[0]);
        int c = Integer.parseInt(st.split(" ")[1]);
        int M = Integer.parseInt(st.split(" ")[2]);
        int N = Integer.parseInt(st.split(" ")[3]);
        char[][] board = new char[r][c];
        boolean[][] visited = new boolean[r][c];
        for (char[] row : board)
            Arrays.fill(row, '.');
        br.readLine();
        for (int i = 0; ((st = br.readLine()) != null); i++)
            board[Integer.parseInt(st.split(" ")[0]) - 1][Integer.parseInt(st.split(" ")[1]) - 1] = 'X';
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] { 0, 0 });
        visited[0][0] = true;
        int odd = 0;
        int even = 0;
        while (!q.isEmpty()) {
            int num = 0;
            int temp = q.size();
            for (int x = 0; x < temp; x++) {
                int[] curr = q.peek();
                q.remove();
                if ((curr[0] - M) >= 0 && (curr[1] - N) >= 0 && board[curr[0] - M][curr[1] - N] == '.') {
                    if (!visited[curr[0] - M][curr[1] - N]) {
                        q.add(new int[] { curr[0] - M, curr[1] - N });
                        visited[curr[0] - M][curr[1] - N] = true;
                        num++;
                    }
                }
                if ((curr[0] - N) >= 0 && (curr[1] - M) >= 0 && board[curr[0] - N][curr[1] - M] == '.') {
                    if (!visited[curr[0] - N][curr[1] - M]) {
                        q.add(new int[] { curr[0] - N, curr[1] - M });
                        visited[curr[0] - N][curr[1] - M] = true;
                        num++;
                    }
                }
                if ((curr[0] - M) >= 0 && (curr[1] + N) < c && board[curr[0] - M][curr[1] + N] == '.') {
                    if (!visited[curr[0] - M][curr[1] + N]) {
                        q.add(new int[] { curr[0] - M, curr[1] + N });
                        visited[curr[0] - M][curr[1] + N] = true;
                        num++;
                    }
                }
                if ((curr[0] - N) >= 0 && (curr[1] + M) < c && board[curr[0] - N][curr[1] + M] == '.') {
                    if (!visited[curr[0] - N][curr[1] + M]) {
                        q.add(new int[] { curr[0] - N, curr[1] + M });
                        visited[curr[0] - N][curr[1] + M] = true;
                        num++;
                    }
                }
                if ((curr[0] + M) < r && (curr[1] - N) >= 0 && board[curr[0] + M][curr[1] - N] == '.') {
                    if (!visited[curr[0] + M][curr[1] - N]) {
                        q.add(new int[] { curr[0] + M, curr[1] - N });
                        visited[curr[0] + M][curr[1] - N] = true;
                        num++;
                    }
                }
                if ((curr[0] + N) < r && (curr[1] - M) >= 0 && board[curr[0] + N][curr[1] - M] == '.') {
                    if (!visited[curr[0] + N][curr[1] - M]) {
                        q.add(new int[] { curr[0] + N, curr[1] - M });
                        visited[curr[0] + N][curr[1] - M] = true;
                        num++;
                    }
                }
                if ((curr[0] + M) < r && (curr[1] + N) < c && board[curr[0] + M][curr[1] + N] == '.') {
                    if (!visited[curr[0] + M][curr[1] + N]) {
                        q.add(new int[] { curr[0] + M, curr[1] + N });
                        visited[curr[0] + M][curr[1] + N] = true;
                        num++;
                    }
                }
                if ((curr[0] + N) < r && (curr[1] + M) < c && board[curr[0] + N][curr[1] + M] == '.') {
                    if (!visited[curr[0] + N][curr[1] + M]) {
                        q.add(new int[] { curr[0] + N, curr[1] + M });
                        visited[curr[0] + N][curr[1] + M] = true;
                        num++;
                    }
                }
            }
        }

        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                int num = 0;
                boolean[][] visited2 = new boolean[r][c];
                if (board[x][y] == '.' && visited[x][y]) {
                    if ((x - M) >= 0 && (y - N) >= 0) {
                        if (board[x - M][y - N] == '.' && !visited2[x - M][y - N]) {

                            num++;
                            visited2[x - M][y - N] = true;
                        }
                    }
                    if ((x - N) >= 0 && (y - M) >= 0) {
                        if (board[x - N][y - M] == '.' && !visited2[x - N][y - M]) {
                            num++;
                            visited2[x - N][y - M] = true;
                        }
                    }
                    if ((x - M) >= 0 && (y + N) < c) {
                        if (board[x - M][y + N] == '.' && !visited2[x - M][y + N]) {
                            num++;
                            visited2[x - M][y + N] = true;
                        }
                    }
                    if ((x - N) >= 0 && (y + M) < c) {
                        if (board[x - N][y + M] == '.' && !visited2[x - N][y + M]) {
                            num++;
                            visited2[x - N][y + M] = true;
                        }
                    }
                    if ((x + M) < r && (y - N) >= 0) {
                        if (board[x + M][y - N] == '.' && !visited2[x + M][y - N]) {
                            num++;
                            visited2[x + M][y - N] = true;
                        }
                    }
                    if ((x + N) < r && (y - M) >= 0) {
                        if (board[x + N][y - M] == '.' && !visited2[x + N][y - M]) {
                            num++;
                            visited2[x + N][y - M] = true;
                        }
                    }
                    if ((x + M) < r && (y + N) < c) {
                        if (board[x + M][y + N] == '.' && !visited2[x + M][y + N]) {
                            num++;
                            visited2[x + M][y + N] = true;
                        }
                    }
                    if ((x + N) < r && (y + M) < c) {
                        if (board[x + N][y + M] == '.' && !visited2[x + N][y + M]) {
                            num++;
                            visited2[x + N][y + M] = true;
                        }
                    }

                }
                if (!visited[x][y]) {

                } else if (num % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }

        System.out.println(even + " " + odd);

    }
}