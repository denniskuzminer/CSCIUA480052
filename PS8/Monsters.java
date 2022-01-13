
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

public class Monsters {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        int n = scnr.nextInt();
        double d = scnr.nextDouble();
        double[][] map = new double[n][2];
        for (int i = 0; i < n; i++) {
            map[i][0] = scnr.nextDouble();
            map[i][1] = scnr.nextDouble();
        }
        DisjointUnionSets dus = new DisjointUnionSets(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.hypot(map[i][0] - map[j][0], map[i][1] - map[j][1]) <= d) {
                    dus.union(i, j);
                }
            }
        }
        System.out.print(Arrays.stream(dus.parent).distinct().count());
    }
}