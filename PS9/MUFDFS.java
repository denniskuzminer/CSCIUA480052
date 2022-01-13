import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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
        for (int i = 0; i < A.length; i++) {
            addEdge(i, i);
        }
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

public class MUFDFS {

    static int time;
    static int count = 0;
    static int sum = 0;
    static ArrayList<Integer> cycle;
    // static int trees;
    static Set<Integer> currSet = new HashSet<Integer>();
    static List<Set<Integer>> trees = new ArrayList<Set<Integer>>();

    static void recDFS(int u, Graph graph, DFSInfo info, int onWhat) {
        // perform a recursive DFS, starting at u
        info.color[u] = 1;
        info.d[u] = ++time;
        Item curr = graph.A[u];
        Set<Integer> currTree = new HashSet<Integer>();
        while (curr != null) {
            int v = curr.data;
            System.out.println(v + " " + u);
            if (info.color[v] == 0) {
                info.parent[v] = u;
                currTree.add(u);
                currTree.add(v);
                recDFS(v, graph, info, onWhat);
            }
            curr = curr.next;
        }
        trees.add(currTree);
        info.color[u] = 2;
        info.f[u] = ++time;
    }

    static DFSInfo DFS(Graph graph, int onWhat) {
        printGraph(graph);
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
                    // System.out.println(i + " " + onWhat + " " + existsEdge(graph, i, onWhat));
                    recDFS(i, graph, info, onWhat);
                } else {
                    System.out.println(i);
                }
            }
        }
        return info;
    }

    static boolean existsEdge(Graph graph, int u, int v) {
        for (Item curr = graph.A[u]; curr != null; curr = curr.next)
            if (curr.data == v)
                return true;
        for (Item curr = graph.A[v]; curr != null; curr = curr.next)
            if (curr.data == u)
                return true;
        return false;
    }

    static void delVertex(Graph graph, int k) {
        graph.A[k] = null;
        for (int i = 0; i < graph.n; i++) {
            if (i != k && existsEdge(graph, i, k)) {
                Item temp = graph.A[i], prev = null;
                if (temp != null && temp.data == k) {
                    graph.A[i] = temp.next;
                    return;
                }
                while (temp != null && temp.data != k) {
                    prev = temp;
                    temp = temp.next;
                }
                if (temp == null)
                    return;

                prev.next = temp.next;
            }
        }
    }

    static void printGraph(Graph g) {
        for (int i = 0; i < g.n; i++) {
            System.out.print(i + ": ");
            for (Item curr = g.A[i]; curr != null; curr = curr.next)
                System.out.print(curr.data + " ");
            System.out.println();
        }
    }

    static BufferedWriter output;

    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS9/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        output = new BufferedWriter(new OutputStreamWriter(System.out, "ASCII"), 4096);
        String st = "";
        int numSets = Integer.parseInt(br.readLine().split(" ")[0]);
        Graph sets = new Graph(numSets + 1);
        ArrayList<List<Integer>> operations = new ArrayList<List<Integer>>();
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            operations
                    .add(Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
        }
        operations.forEach(operation -> {
            if (operation.get(0) == 1) {
                sets.addEdge(operation.get(1), operation.get(2));
                sets.addEdge(operation.get(2), operation.get(1));
            }
            if (operation.get(0) == 2) {
                delVertex(sets, operation.get(1));
                sets.addEdge(operation.get(1), operation.get(2));
                sets.addEdge(operation.get(2), operation.get(1));
            }
            if (operation.get(0) == 3) {
                currSet.clear();
                trees.clear();
                count = 1;
                sum = operation.get(1);
                DFS(sets, operation.get(1));
                System.out.println(trees);
                // System.out.println(currSet.size() + " " +
                // currSet.stream().mapToInt(Integer::intValue).sum());
                // for (int i = 0; i < sets.n; i++) {
                // if (existsEdge(sets, operation.get(1), i)) {
                // count++;
                // sum += i;
                // }
                // }
                // for (Item curr = sets.A[operation.get(1)]; curr != null; count++, sum +=
                // curr.data, curr = curr.next) {
                // }
                try {
                    output.write(currSet.size() + " " + currSet.stream().mapToInt(Integer::intValue).sum() + "\n");
                } catch (IOException e) {
                }
            }
        });
        output.flush();
    }
}