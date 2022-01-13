
// This code uses code from https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/.
import java.util.*;
import java.io.*;

class Main {
    final static int INF = 99999;
    static int V;
    static List<int[]> adj = new ArrayList<int[]>();
    static int E = 0;

    void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];
        int i, j, k;

        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        for (k = 0; k < V; k++)
            for (i = 0; i < V; i++)
                for (j = 0; j < V; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        System.out.println(dist[0][dist[0].length - 1] > -100 ? "winnable" : "hopeless");
        printSolution(dist);
    }

    void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest " + "distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS11/input.txt");
        Scanner br = new Scanner(new FileReader(file));
        // Scanner br = new Scanner(new InputStreamReader(System.in));
        int v = br.nextInt();
        int[][] graph = new int[v][v];
        V = v;
        for (int i = 0; i < v; i++) {
            Arrays.fill(graph[i], INF);
            int w = br.nextInt();
            // System.out.print(w + " ");
            int numConnections = br.nextInt();
            // System.out.print(numConnections + " ");
            for (int j = 0; j < numConnections; j++) {
                int to = br.nextInt() - 1;
                graph[i][to] = w;
                adj.add(new int[] { i, to, w });
                E++;
                // System.out.print(to + " ");
            }
            graph[i][i] = 0;
            // System.out.println();
        }
        Main a = new Main();
        a.floydWarshall(graph);
    }
}