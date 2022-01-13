import java.io.*;
import java.util.*;

// Data structure for a node in a linked list
class Item {
    int data;
    Item next;

    Item(int data, Item next) {
        this.data = data;
        this.next = next;
    }
}

// Data structure for representing a graph
class Graph {
    int n; // # of nodes in the graph

    Item[] A;
    // For u in [0..n), A[u] is the adjecency list for u

    Graph(int n) {
        // initialize a graph with n vertices and no edges
        this.n = n;
        A = new Item[n];
    }

    void addEdge(int u, int v) {
        // add an edge i -> j to the graph

        A[u] = new Item(v, A[u]);
    }
}

// Data structure holding data computed by DFS
class DFSInfo {

    // node colors
    static final int WHITE = 0;
    static final int GRAY = 1;
    static final int BLACK = 2;

    int[] color; // variable storing the color
                 // of each node during DFS
                 // (WHITE, GRAY, or BLACK)

    int[] parent; // variable storing the parent
                  // of each node in the DFS forest

    int d[]; // variable storing the discovery time
             // of each node in the DFS forest

    int f[]; // variable storing the finish time
             // of each node in the DFS forest

    DFSInfo(Graph graph) {
        int n = graph.n;
        color = new int[n];
        parent = new int[n];
        d = new int[n];
        f = new int[n];
    }
}

// your "main program" should look something like this:

class PolarDFS {
    static int time;
    static ArrayList<Integer> cycle;
    static int trees;

    static void recDFS(int u, Graph graph, DFSInfo info) {
        // perform a recursive DFS, starting at u
        info.color[u] = 1;
        info.d[u] = ++time;
        Item curr = graph.A[u];
        while (curr != null) {
            int v = curr.data;
            if (info.color[v] == 0) {
                info.parent[v] = u;
                recDFS(v, graph, info);
            }
            curr = curr.next;
        }
        info.color[u] = 2;
        info.f[u] = ++time;

        /*
         * for (int i = 1; i < n; i++) { if (g.A[i] != null) { ArrayList<Item>
         * successors = new ArrayList<Item>(); Item curr = g.A[i]; while (curr != null)
         * { successors.add(curr); System.out.println(i + " " + curr.data); curr =
         * curr.next; } } }
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * int index = -1; for (int i = 0; i < graph.n; i++) { if (graph.A[i] != null &&
         * graph.A[i].data == u) { index = i; break; } } info.color[index] = 1;
         * info.d[index] = ++time; ArrayList<Item> successors = new ArrayList<Item>();
         * for (int i = 0; i < graph.n; i++) { if (graph.A[i] != null &&
         * graph.A[index].data == graph.A[i].data) { successors.add(graph.A[i].next); }
         * } for (Item successor : successors) { int successorIndex = -1; for (int i =
         * 0; i < graph.n; i++) { if ((graph.A[i] != null && successor != null) &&
         * graph.A[i].data == successor.data) { successorIndex = i; break; } } if
         * (successorIndex != -1 && info.color[successorIndex] == 0) {
         * info.parent[successorIndex] = u; recDFS(successor.data, graph, info); } }
         * info.color[index] = 2; info.f[index] = ++time;
         */

        /*
         * for (int i = 0; i < numSuccessors; i++) { if (graph.A[index].next.data == ) {
         * successors; } }
         */

    }

    static DFSInfo DFS(Graph graph) {
        // performs a "full" DFS on given graph
        DFSInfo info = new DFSInfo(graph);
        for (int i = 0; i < graph.n; i++) {
            info.parent[i] = 0;
            info.color[i] = 0;
        }
        time = 0;
        for (int i = 0; i < graph.n; i++) {
            if (info.color[i] == 0) {
                if (graph.A[i] != null) {
                    trees++;
                    recDFS(i, graph, info);
                }
            }
        }
        return info;
    }

    static boolean existsEdge(Graph graph, int u, int v) {
        // if there is an edge from u to v
        Item curr = graph.A[u];
        while (curr != null) {
            if (curr.data == v) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS7/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String input = "";
        String st = br.readLine();
        int n = Integer.parseInt(st.split(" ")[0]);
        int m = Integer.parseInt(st.split(" ")[1]);
        int[][] map = new int[n][m];
        for (int i = 0; i < n && ((st = br.readLine()) != null); i++) {
            map[i] = Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.readLine();
        int[] queries = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // int[] arr = Arrays.stream(br.readLine().split("
        // ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(findSafeSpaces(map, queries));
    }

    public static String findSafeSpaces(int[][] map, int[] queries) {
        String ans = "";
        int[][] vertices = new int[map.length][map[0].length];
        int num = 0;
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices[0].length; j++, num++) {
                vertices[i][j] = num;
            }
        }
        // System.out.println(Arrays.deepToString(vertices));
        for (int k = 0; k < queries.length; k++) {
            int query = queries[k];
            trees = 0;
            Graph islands = new Graph((map.length * map[0].length));
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] > query) {
                        islands.addEdge(vertices[i][j], vertices[i][j]);
                        if (i != 0 && map[i - 1][j] > query
                                && !existsEdge(islands, vertices[i][j], vertices[i - 1][j])) {
                            islands.addEdge(vertices[i][j], vertices[i - 1][j]);
                        }
                        if (i != (map.length - 1) && map[i + 1][j] > query
                                && !existsEdge(islands, vertices[i][j], vertices[i + 1][j])) {
                            islands.addEdge(vertices[i][j], vertices[i + 1][j]);
                        }
                        if (j != 0 && map[i][j - 1] > query
                                && !existsEdge(islands, vertices[i][j], vertices[i][j - 1])) {
                            islands.addEdge(vertices[i][j], vertices[i][j - 1]);
                        }
                        if (j != (map[0].length - 1) && map[i][j + 1] > query
                                && !existsEdge(islands, vertices[i][j], vertices[i][j + 1])) {
                            islands.addEdge(vertices[i][j], vertices[i][j + 1]);
                        }
                    }
                }
            }

            // System.out.println("For query " + query);
            // for (int i = 0; i < (map.length * map[0].length); i++) {
            // Item curr = islands.A[i];
            // if (curr != null) {
            // // System.out.print(i);
            // }
            // while (curr != null) {
            // // System.out.print(curr.data + " ");
            // curr = curr.next;
            // if (curr == null) {
            // // System.out.println("");
            // }
            // }
            // }
            DFSInfo info = DFS(islands);
            System.out.print(k == queries.length - 1 ? trees : trees + " ");
            // System.out.println("Trees: " + trees);
        }
        return "";
    }
}

// 5 20
// 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
// 1 4 5 5 6 7 8 9 39 9 0 9 9 9 9 9 9 9 9 9
// 1 1 2 3 4 5 6 7 8 9 2 3 45 2 2 4 32 3 33 3
// 1 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 100000
// 1 8 9 8 1 7 5 1 3 4 2 3 3 5 6 7 78 6 4 3 3
// 3
// 2 45 1000