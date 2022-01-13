// import java.io.*;
// import java.util.*;

// // This class represents a directed Gr
// // using adjacency list representation
// public class Main {

//     // No. of vertices
//     int V;

//     // Adjacency Lists
//     LinkedList<Integer> adj[];
//     int Time;
//     ArrayList<SCComponent> sccs;

//     // Constructor
//     Main(int v) {
//         V = v;
//         adj = new LinkedList[v];
//         sccs = new ArrayList<SCComponent>();
//         for (int i = 0; i < v; ++i)
//             adj[i] = new LinkedList<Integer>();

//         Time = 0;
//     }

//     // Function to add an edge into the Gr
//     void addEdge(int v, int w) {
//         adj[v].add(w);
//     }

//     // A recursive function that finds and prints strongly
//     // connected SCComponents using DFS traversal
//     // u --> The vertex to be visited next
//     // disc[] --> Stores discovery times of visited vertices
//     // low[] -- >> earliest visited vertex (the vertex with
//     // minimum discovery time) that can be reached
//     // from subtree rooted with current vertex
//     // st -- >> To store all the connected ancestors (could be part
//     // of SCC)
//     // stackMember[] --> bit/index array for faster check
//     // whether a node is in stack
//     void SCCUtil(int u, int low[], int disc[], boolean stackMember[], Stack<Integer> st) {

//         // Initialize discovery time and low value
//         disc[u] = Time;
//         low[u] = Time;
//         Time += 1;
//         stackMember[u] = true;
//         st.push(u);

//         int n;

//         // Go through all vertices adjacent to this
//         Iterator<Integer> i = adj[u].iterator();

//         while (i.hasNext()) {
//             n = i.next();

//             if (disc[n] == -1) {
//                 SCCUtil(n, low, disc, stackMember, st);

//                 // Check if the subtree rooted with v
//                 // has a connection to one of the
//                 // ancestors of u
//                 // Case 1 (per above discussion on
//                 // Disc and Low value)
//                 low[u] = Math.min(low[u], low[n]);
//             } else if (stackMember[n] == true) {

//                 // Update low value of 'u' only if 'v' is
//                 // still in stack (i.e. it's a back edge,
//                 // not cross edge).
//                 // Case 2 (per above discussion on Disc
//                 // and Low value)
//                 low[u] = Math.min(low[u], disc[n]);
//             }
//         }

//         // head node found, pop the stack and print an SCC
//         // To store stack extracted vertices
//         int w = -1;
//         if (low[u] == disc[u]) {
//             SCComponent SCComponent = new SCComponent();
//             while (w != u) {
//                 w = (int) st.pop();
//                 SCComponent.cycle.add(w);
//                 stackMember[w] = false;
//             }
//             sccs.add(SCComponent);
//         }
//     }

//     // The function to do DFS traversal.
//     // It uses SCCUtil()
//     void SCC() {

//         // Mark all the vertices as not visited
//         // and Initialize parent and visited,
//         // and ap(articulation point) arrays
//         int disc[] = new int[V];
//         int low[] = new int[V];
//         for (int i = 0; i < V; i++) {
//             disc[i] = -1;
//             low[i] = -1;
//         }

//         boolean stackMember[] = new boolean[V];
//         Stack<Integer> st = new Stack<Integer>();

//         // Call the recursive helper function
//         // to find articulation points
//         // in DFS tree rooted with vertex 'i'
//         for (int i = 0; i < V; i++) {
//             if (disc[i] == -1)
//                 SCCUtil(i, low, disc, stackMember, st);
//         }
//     }

//     String[] existsConnection(SCComponent c1, SCComponent c2) {
//         int num = 0;
//         int[] edge = new int[2];
//         for (int[] outedge : c1.out) {
//             if (c2.cycle.contains(new Integer(outedge[1]))) {
//                 edge = outedge;
//                 num++;
//             }
//         }

//         return new String[] { num + "", edge[0] + " " + edge[1] };
//     }

//     // Driver code
//     public static void main(String args[]) throws Exception {
//         // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS12/input.txt");
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         // BufferedReader br = new BufferedReader(new FileReader(file));
//         String st = br.readLine();

//         Main g1 = new Main(Integer.parseInt(st));
//         int[][] edges = new int[Integer.parseInt(br.readLine())][2];
//         for (int i = 0; ((st = br.readLine()) != null); i++) {
//             g1.addEdge(Integer.parseInt(st.split(" ")[0]), Integer.parseInt(st.split(" ")[1]));
//             edges[i][0] = Integer.parseInt(st.split(" ")[0]);
//             edges[i][1] = Integer.parseInt(st.split(" ")[1]);
//         }
//         g1.SCC();
//         for (int[] edge : edges) {
//             g1.sccs.forEach(scc -> {
//                 if (scc.cycle.indexOf(edge[0]) != -1) {
//                     if (scc.cycle.indexOf(edge[1]) != -1) {
//                         scc.in.add(new int[] { edge[0], edge[1] });
//                     } else {
//                         scc.out.add(new int[] { edge[0], edge[1] });
//                     }
//                 }
//             });
//         }
//         int max = Integer.MIN_VALUE;
//         String ans = "";
//         // System.out.println(g1.sccs);
//         for (SCComponent i : g1.sccs) {
//             for (SCComponent j : g1.sccs) {
//                 String[] con = g1.existsConnection(i, j);
//                 // System.out.println(Arrays.toString(g1.existsConnection(i, j)));
//                 if (Integer.parseInt(con[0]) == 1) {
//                     if (Math.abs(i.cycle.size() - j.cycle.size()) > max) {
//                         ans += con[1] + "\n" + Math.abs(i.cycle.size() - j.cycle.size());
//                         max = Math.abs(i.cycle.size() - j.cycle.size());
//                     }
//                 }
//             }
//         }
//         if (max == Integer.MIN_VALUE) {
//             System.out.println("No critical connection");
//         } else {
//             System.out.println(ans);
//         }
//     }
// }

// class SCComponent {
//     ArrayList<Integer> cycle = new ArrayList<Integer>();
//     ArrayList<int[]> in = new ArrayList<int[]>();
//     ArrayList<int[]> out = new ArrayList<int[]>();

//     public SCComponent() {

//     }

//     @Override
//     public String toString() {
//         String ret = cycle.toString();
//         ret += " in edges ";
//         for (int[] arr : in) {
//             ret += Arrays.toString(arr);
//             ret += " ";
//         }
//         ret += " out edges ";
//         for (int[] arr : out) {
//             ret += Arrays.toString(arr);
//             ret += " ";
//         }
//         return ret;
//     }
// }
