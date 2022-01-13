// Solution utilizes https://www.programmerall.com/article/37491103032/

import java.util.*;
import java.io.*;

public class Stars {

    static int MAX_VALUE = 32000 + 10;
    static int[] bit = new int[MAX_VALUE];
    static int[] arr = new int[MAX_VALUE];
    static Node[] data = new Node[MAX_VALUE];

    static int n, max;

    static void add(int x, int y) {
        while (x <= max) {
            bit[x] += y;
            x += x & -x;
        }
    }

    static int sum(int x) {
        int s = 0;
        while (x >= 1) {
            s += bit[x];
            x -= x & -x;
        }
        return s;
    }

    static int comp(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

    public static void main(String[] args) throws Exception {
        // File file = new File("C:/Users/denni/Comp
        // Sci/CSCIUA480052/Recitation14/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int n = Integer.parseInt(st);
        max = 0;
        for (int i = 1; ((st = br.readLine()) != null); i++) {
            // System.out.println(Arrays.toString(data));
            data[i] = new Node();
            data[i].x = Integer.parseInt(st.split(" ")[0]) + 1;
            data[i].y = Integer.parseInt(st.split(" ")[1]);
            max = Math.max(max, data[i].x);
        }
        Arrays.sort(data, 1, 1 + n, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if (a.y == b.y)
                    return comp(a.x, b.x);
                return comp(a.y, b.y);
            }
        });
        for (int i = 1; i <= n; i++) {
            data[i].level = sum(data[i].x);
            add(data[i].x, 1);
        }
        for (int i = 1; i <= n; i++) {
            arr[data[i].level]++;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

}

class Node {
    int x, y, level;

    public Node() {
    }
}
