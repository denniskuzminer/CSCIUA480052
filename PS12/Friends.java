// This code uses https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

import java.io.*;
import java.util.*;

public class Friends {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS12/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int score = Integer.parseInt(st.trim().replaceAll(" +", " ").split(" ")[0]);
        int V = Integer.parseInt(br.readLine());
        Graph g = new Graph(1000001);
        Set<Integer> vertices = new TreeSet<Integer>();
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            try {
                g.addEdge(Integer.parseInt(st.split(" ")[0]), Integer.parseInt(st.split(" ")[1]));
                g.addEdge(Integer.parseInt(st.split(" ")[1]), Integer.parseInt(st.split(" ")[0]));
                vertices.add(Integer.parseInt(st.split(" ")[0]));
                vertices.add(Integer.parseInt(st.split(" ")[1]));
            } catch (Exception e) {
                break;
            }
        }
        for (Integer v : vertices) {
            g.BFS(v);
            int numFriends = 0;
            for (Integer u : vertices) {
                numFriends += g.dist[u] <= score && g.dist[u] != 0 ? 1 : 0;
            }
            System.out.println(v + " " + numFriends);
        }
    }
}

class Graph {
    int V;
    LinkedList<Integer> adj[];
    boolean visited[];
    long dist[];
    List<Integer> bfs;

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    int num = 0;

    void BFS(int s) {
        int init = s;
        visited = new boolean[V];
        dist = new long[V];
        bfs = new ArrayList<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (init != n && !visited[n])
                    dist[n] = dist[s] + 1;
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}