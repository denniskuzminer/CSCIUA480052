// import java.io.*;
// import java.math.BigInteger;
// import java.util.*;
// import java.util.stream.Collectors;

// public class Hacker {
//     public static void main(String args[]) throws Exception {
//         File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS12/input.txt");
//         // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedReader br = new BufferedReader(new FileReader(file));
//         String st = br.readLine();
//         int numPeople = Integer.parseInt(st);
//         TreeMap<String, String> chats = new TreeMap<String, String>();
//         EncryptionParams[] eq = new EncryptionParams[numPeople + 1];
//         DisjointUnionSets groups = new DisjointUnionSets(numPeople + 1);
//         for (; ((st = br.readLine()) != null);) {
//             int[] arr = Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).toArray();
//             if (eq[arr[1]] == null)
//                 eq[arr[1]] = new EncryptionParams(arr[1]);
//             chats.put(arr[0] + " " + arr[1],
//                     chats.get(arr[0] + " " + arr[1]) != null
//                             ? chats.get(arr[0] + " " + arr[1]) + eq[arr[1]].decrypt(arr[2])
//                             : "" + eq[arr[1]].decrypt(arr[2]));
//             groups.union(arr[0], arr[1]);
//         }
//         HashMap<Integer, String> print = new HashMap<Integer, String>();
//         for (int i = 0; i < 11; i++) {
//             for (var elem : chats.entrySet()) {
//                 String info = (String) elem.getKey();
//                 if (info.split(" ")[1].equals(i + ""))
//                     // System.out.println("Person " + i + " Received: " + chats.get(info));
//                     print.put(i, print.get(i) != null ? print.get(i) + chats.get(info) : "" + chats.get(info));
//             }
//         }
//         HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
//         for (int i = 1; i < groups.parent.length; i++) {
//             int parent = groups.find(i);
//             if (map.get(parent) == null) {
//                 map.put(parent, new ArrayList<Integer>());
//             }
//             map.get(parent).add(i);
//         }
//         TreeMap<Integer, List<Integer>> sortedGroups = new TreeMap<Integer, List<Integer>>();
//         for (List<Integer> entry : map.values()) {
//             sortedGroups.put(entry.get(0), entry);
//         }

//         sortedGroups.forEach((key, group) -> {
//             System.out.println(group);
//         });
//         print.forEach((i, chat) -> {
//             System.out.println("Person " + i + " Received: " + chat);
//         });
//     }

// }

// class EncryptionParams {
//     BigInteger p, q, phi, n, d, e;
//     int receiver;
//     int[][] pq = new int[][] { { 11, 101, 1000, 1111, 3, 667 }, { 113, 131, 14560, 14803, 3, 9707 },
//             { 173, 181, 30960, 31313, 7, 4423 }, { 191, 313, 59280, 59783, 7, 42343 },
//             { 359, 373, 133176, 133907, 5, 106541 }, { 419, 727, 303468, 304613, 5, 182081 },
//             { 743, 757, 560952, 562451, 5, 224381 }, { 761, 787, 597360, 598907, 7, 512023 },
//             { 809, 919, 741744, 743471, 5, 148349 }, { 953, 10301, 9805600, 9816853, 3, 6537067 }, };

//     public EncryptionParams(int receiver) {
//         this.receiver = receiver;
//         map(receiver);
//     }

//     char decrypt(int encrypted) {
//         BigInteger c = new BigInteger("" + encrypted);
//         return (char) c.modPow(d, n).intValueExact();
//     }

//     void map(int receiver) {
//         p = new BigInteger("" + pq[receiver - 1][0]);
//         q = new BigInteger("" + pq[receiver - 1][1]);
//         phi = new BigInteger("" + pq[receiver - 1][2]);
//         n = new BigInteger("" + pq[receiver - 1][3]);
//         e = new BigInteger("" + pq[receiver - 1][4]);
//         d = new BigInteger("" + pq[receiver - 1][5]);
//     }
// }

// class DisjointUnionSets {
//     int[] rank, parent;
//     int n;

//     public DisjointUnionSets(int n) {
//         rank = new int[n];
//         parent = new int[n];
//         this.n = n;
//         makeSet();
//     }

//     void makeSet() {
//         for (int i = 0; i < n; i++) {
//             parent[i] = i;
//         }
//     }

//     int find(int x) {
//         if (parent[x] != x) {
//             parent[x] = find(parent[x]);
//         }
//         return parent[x];
//     }

//     void union(int x, int y) {
//         int xRoot = find(x), yRoot = find(y);
//         if (xRoot == yRoot)
//             return;
//         if (rank[xRoot] < rank[yRoot])
//             parent[xRoot] = yRoot;
//         else if (rank[yRoot] < rank[xRoot])
//             parent[yRoot] = xRoot;
//         else {
//             parent[yRoot] = xRoot;
//             rank[xRoot] = rank[xRoot] + 1;
//         }
//     }
// }