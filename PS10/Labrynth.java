// This code was written with the help of Brian Guo

import java.io.*;
import java.util.*;

public class Labrynth {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS10/input.txt");
        Scanner br = new Scanner(System.in);
        // Scanner br = new Scanner(new FileReader(file));
        String st = br.nextLine();
        int k = Integer.parseInt(st.split(" ")[0]);
        int n = Integer.parseInt(st.split(" ")[1]);
        int m = Integer.parseInt(st.split(" ")[2]);
        int[] start = new int[3];
        char[][][] arr = new char[k][n][m];
        boolean[][][] visited = new boolean[k][n][m];

        for (int x = 0; x < k; x++) {
            for (int y = 0; y < n; y++) {
                if (br.hasNext()) {
                    char[] hi = br.next().toCharArray();
                    for (int z = 0; z < m; z++) {
                        arr[x][y][z] = hi[z];
                        // System.out.println(br.next());
                        if (arr[x][y][z] == 'S') {
                            start[0] = x;
                            start[1] = y;
                            start[2] = z;
                        }
                        // System.out.print(arr[x][y][z]);
                    }
                }
                // System.out.println();
            }
            if (br.hasNext()) {
                br.nextLine();
            }
            // System.out.println();
        }
        // System.out.println(Arrays.deepToString(arr));
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] { start[0], start[1], start[2] });
        visited[start[0]][start[1]][start[2]] = true;

        int res = 0;
        while (!q.isEmpty()) {
            int temp = q.size();
            for (int x = 0; x < temp; x++) {
                int[] curr = q.peek();
                q.remove();
                if (arr[curr[0]][curr[1]][curr[2]] == 'E') {
                    System.out.println("Escaped in " + res + " minute(s).");
                    return;
                }
                if (((curr[0] - 1) >= 0)
                        && (arr[curr[0] - 1][curr[1]][curr[2]] == '.' || arr[curr[0] - 1][curr[1]][curr[2]] == 'E')) {
                    if (!visited[curr[0] - 1][curr[1]][curr[2]]) {
                        q.add(new int[] { curr[0] - 1, curr[1], curr[2] });
                        visited[curr[0] - 1][curr[1]][curr[2]] = true;
                    }
                }
                if (((curr[0] + 1)) < k
                        && (arr[curr[0] + 1][curr[1]][curr[2]] == '.' || arr[curr[0] + 1][curr[1]][curr[2]] == 'E')) {
                    if (!visited[curr[0] + 1][curr[1]][curr[2]]) {
                        q.add(new int[] { curr[0] + 1, curr[1], curr[2] });
                        visited[curr[0] + 1][curr[1]][curr[2]] = true;
                    }
                }
                if (((curr[1] - 1)) >= 0
                        && (arr[curr[0]][curr[1] - 1][curr[2]] == '.' || arr[curr[0]][curr[1] - 1][curr[2]] == 'E')) {
                    if (!visited[curr[0]][curr[1] - 1][curr[2]]) {
                        q.add(new int[] { curr[0], curr[1] - 1, curr[2] });
                        visited[curr[0]][curr[1] - 1][curr[2]] = true;
                    }
                }
                if (((curr[1] + 1)) < n
                        && (arr[curr[0]][curr[1] + 1][curr[2]] == '.' || arr[curr[0]][curr[1] + 1][curr[2]] == 'E')) {
                    if (!visited[curr[0]][curr[1] + 1][curr[2]]) {
                        q.add(new int[] { curr[0], curr[1] + 1, curr[2] });
                        visited[curr[0]][curr[1] + 1][curr[2]] = true;
                    }
                }
                if (((curr[2] - 1)) >= 0
                        && (arr[curr[0]][curr[1]][curr[2] - 1] == '.' || arr[curr[0]][curr[1]][curr[2] - 1] == 'E')) {
                    if (!visited[curr[0]][curr[1]][curr[2] - 1]) {
                        q.add(new int[] { curr[0], curr[1], curr[2] - 1 });
                        visited[curr[0]][curr[1]][curr[2] - 1] = true;
                    }

                }
                if (((curr[2] + 1)) < m
                        && (arr[curr[0]][curr[1]][curr[2] + 1] == '.' || arr[curr[0]][curr[1]][curr[2] + 1] == 'E')) {
                    if (!visited[curr[0]][curr[1]][curr[2] + 1]) {
                        q.add(new int[] { curr[0], curr[1], curr[2] + 1 });
                        visited[curr[0]][curr[1]][curr[2] + 1] = true;
                    }
                }
            }
            res++;
        }

        System.out.println("Trapped!");

    }
}