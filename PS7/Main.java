
// ****************18.5/20*************
// This solution uses code that is taken directly from https://www.geeksforgeeks.org/disjoint-set-data-structures/ for disjoint set implementation
// and uses code directly from https://www.geeksforgeeks.org/find-the-number-of-islands-set-2-using-disjoint-set/?ref=rp for island counting  
import java.io.*;
import java.util.*;

class DisjointUnionSets {
    int[] rank, parent;
    int n;

    public DisjointUnionSets(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }

    void makeSet() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot == yRoot)
            return;
        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[yRoot] < rank[xRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        int n = Integer.parseInt(st.split(" ")[0]);
        int m = Integer.parseInt(st.split(" ")[1]);
        int[][] map = new int[n][m];
        for (int i = 0; i < n && ((st = br.readLine()) != null); i++) {
            map[i] = Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.readLine();
        int[] queries = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] vertices = new int[map.length][map[0].length];
        int num = 0;
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices[0].length; j++, num++) {
                vertices[i][j] = num;
            }
        }
        for (int k = 0; k < queries.length; k++) {
            int query = queries[k];
            DisjointUnionSets dus = new DisjointUnionSets(n * m);
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] > query) {
                        dus.union(vertices[i][j], vertices[i][j]);
                        if (i != 0 && map[i - 1][j] > query) {
                            dus.union(vertices[i][j], vertices[i - 1][j]);
                        }
                        if (i != (map.length - 1) && map[i + 1][j] > query) {
                            dus.union(vertices[i][j], vertices[i + 1][j]);
                        }
                        if (j != 0 && map[i][j - 1] > query) {
                            dus.union(vertices[i][j], vertices[i][j - 1]);
                        }
                        if (j != (map[0].length - 1) && map[i][j + 1] > query) {
                            dus.union(vertices[i][j], vertices[i][j + 1]);
                        }
                    }
                }
            }
            int[] c = new int[n * m];
            int numberOfIslands = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > query) {
                        int x = dus.find(vertices[i][j]);
                        if (c[x] == 0) {
                            numberOfIslands++;
                            c[x]++;
                        } else
                            c[x]++;
                    }
                }
            }
            System.out.print(k == queries.length - 1 ? numberOfIslands : numberOfIslands + " ");
        }
        System.out.println("");
    }
}