
//Lauren Gatesman helped me with the print outs
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static Receiver[] pq = new Receiver[11];

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS12/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int numPeople = Integer.parseInt(st);

        TreeMap<Integer, StringBuilder> chats = new TreeMap<Integer, StringBuilder>();

        DisjointUnionSets groups = new DisjointUnionSets(numPeople + 1);

        pq[1] = new Receiver(BigInteger.valueOf(11), BigInteger.valueOf(101), BigInteger.valueOf(1000),
                BigInteger.valueOf(1111), 3, BigInteger.valueOf(667));
        pq[2] = new Receiver(BigInteger.valueOf(113), BigInteger.valueOf(131), BigInteger.valueOf(14560),
                BigInteger.valueOf(14803), 3, BigInteger.valueOf(9707));
        pq[3] = new Receiver(BigInteger.valueOf(173), BigInteger.valueOf(181), BigInteger.valueOf(30960),
                BigInteger.valueOf(31313), 7, BigInteger.valueOf(4423));
        pq[4] = new Receiver(BigInteger.valueOf(191), BigInteger.valueOf(313), BigInteger.valueOf(59280),
                BigInteger.valueOf(59783), 7, BigInteger.valueOf(42343));
        pq[5] = new Receiver(BigInteger.valueOf(359), BigInteger.valueOf(373), BigInteger.valueOf(133176),
                BigInteger.valueOf(133907), 5, BigInteger.valueOf(106541));
        pq[6] = new Receiver(BigInteger.valueOf(419), BigInteger.valueOf(727), BigInteger.valueOf(303468),
                BigInteger.valueOf(304613), 5, BigInteger.valueOf(182081));
        pq[7] = new Receiver(BigInteger.valueOf(743), BigInteger.valueOf(757), BigInteger.valueOf(560952),
                BigInteger.valueOf(562451), 5, BigInteger.valueOf(224381));
        pq[8] = new Receiver(BigInteger.valueOf(761), BigInteger.valueOf(787), BigInteger.valueOf(597360),
                BigInteger.valueOf(598907), 7, BigInteger.valueOf(512023));
        pq[9] = new Receiver(BigInteger.valueOf(809), BigInteger.valueOf(919), BigInteger.valueOf(741744),
                BigInteger.valueOf(743471), 5, BigInteger.valueOf(148349));
        pq[10] = new Receiver(BigInteger.valueOf(953), BigInteger.valueOf(10301), BigInteger.valueOf(9805600),
                BigInteger.valueOf(9816853), 3, BigInteger.valueOf(6537067));
        for (; ((st = br.readLine()) != null);) {
            int[] arr = Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).toArray();

            int c = arr[2];

            if (chats.containsKey(arr[1])) {
                StringBuilder current = chats.get(arr[1]);
                current.append(decrypt(c, arr[1]));
            } else {
                StringBuilder empty = new StringBuilder("");
                empty.append(decrypt(c, arr[1]));
                chats.put(arr[1], empty);
            }

            groups.union(arr[0], arr[1]);
        }

        // Print out each set, sorted, with the first integer in the set being in order
        Map<Integer, ArrayList<Integer>> print = new HashMap<Integer, ArrayList<Integer>>();

        for (int a = 1; a <= numPeople; a++) {
            if (groups.find(a) == a) {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(a);
                print.put(a, arr);
            }
        }
        for (int b = 1; b <= numPeople; b++) {
            if (groups.find(b) != b) {
                print.get(groups.find(b)).add(b);
            }
        }

        Map<Integer, ArrayList<Integer>> print2 = new HashMap<Integer, ArrayList<Integer>>();

        for (int c = 1; c <= numPeople; c++) {
            if (print.containsKey(c)) {
                Collections.sort(print.get(c));
                print2.put(print.get(c).get(0), print.get(c));
            }
        }

        for (int d = 1; d <= numPeople; d++) {
            if (print2.containsKey(d)) {
                System.out.println(print2.get(d));
            }
        }

        for (int e = 1; e <= numPeople; e++) {
            if (chats.containsKey(e)) {
                System.out.println("Person " + e + " Received: " + chats.get(e));
            }
        }

    }

    static char decrypt(int encrypted, int receiver) {
        BigInteger c = new BigInteger("" + encrypted);
        return (char) c.modPow(pq[receiver].d, pq[receiver].n).intValueExact();
    }

}

class Receiver {
    BigInteger p, q, phi, d, n;
    Integer e;
    int receiver;

    Receiver(BigInteger p, BigInteger q, BigInteger phi, BigInteger n, int e, BigInteger d) {
        this.p = p;
        this.q = q;
        this.phi = phi;
        this.n = n;
        this.d = d;
        this.e = e;
    }
}

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