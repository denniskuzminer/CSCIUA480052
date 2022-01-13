
// This solution uses code that is taken directly from https://www.geeksforgeeks.org/disjoint-set-data-structures/ for disjoint set implementation
// and was *inspired* by Brian Guo  

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class DisjointUnionSets {
    long[] rank, parent, old, size, count;
    int n;

    public DisjointUnionSets(int n) {
        rank = new long[n];
        parent = new long[n];
        old = new long[n];
        size = new long[n];
        count = new long[n];
        this.n = n;
        makeSet();
    }

    void makeSet() {
        for (int i = 0; i < n; i++)
            parent[i] = i;
        for (int i = 0; i < n; i++)
            old[i] = i;
        for (int i = 0; i < n; i++)
            size[i] = i + 1;
        for (int i = 0; i < n; i++)
            count[i] = 1;
    }

    int firstFind(int x) {
        if (old[x] != x) {

            return (int) find((int) old[(int) x]);
        } else {
            return (int) find((int) parent[(int) x]);
        }
    }

    long find(int x) {
        if (old[x] != x) {
            old[x] = (int) find((int) old[(int) x]);
        }
        return old[(int) x];
    }

    void union(int x, int y) {
        int xRoot = firstFind(x);
        int yRoot = firstFind(y);

        if (xRoot == yRoot)
            return;

        parent[yRoot] = xRoot;
        old[yRoot] = xRoot;
        size[xRoot] += size[yRoot];
        count[xRoot] += count[yRoot];
    }

    void move(int x, int y) {
        int xset = firstFind(x);
        int yset = firstFind(y);
        if (xset != yset) {
            parent[x] = yset;
            size[yset] += x + 1;
            size[xset] -= x + 1;
            count[xset] -= 1;
            count[yset] += 1;
        }
    }
}

public class Main {

    static BufferedWriter output;

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS9/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        output = new BufferedWriter(new OutputStreamWriter(System.out, "ASCII"), 4096);
        String st = "";
        int numSets = Integer.parseInt(br.readLine().split(" ")[0]);
        DisjointUnionSets dus = new DisjointUnionSets(numSets);
        // ArrayList<List<Integer>> operations = new ArrayList<List<Integer>>();
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            List<Integer> operation = (Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).boxed()
                    .collect(Collectors.toList()));
            if (operation.get(0) == 1) {
                dus.union(operation.get(1) - 1, operation.get(2) - 1);
            }
            if (operation.get(0) == 2) {
                dus.move(operation.get(1) - 1, operation.get(2) - 1);
            }
            if (operation.get(0) == 3) {
                try {
                    output.write((dus.count[dus.firstFind(operation.get(1) - 1)]) + " "
                            + (dus.size[dus.firstFind(operation.get(1) - 1)]) + "\n");
                } catch (IOException e) {
                }
            }
        }
        output.flush();
    }
}