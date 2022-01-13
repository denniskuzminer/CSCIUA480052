// This code uses https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

import java.io.*;
import java.util.*;

public class Edit2 {
  public static void main(String args[]) throws Exception {
    // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Final/input.txt");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedReader br = new BufferedReader(new FileReader(file));
    String st = "";
    int n = Integer.parseInt(br.readLine());
    Graph g = new Graph(201);
    ArrayList<String> dict = new ArrayList<String>();
    for (int i = 0; i < n && ((st = br.readLine()) != null); i++)
      dict.add(st);
    int m = Integer.parseInt(br.readLine());
    constructGraph(g, dict);
    for (; ((st = br.readLine()) != null);) {
      g.BFS(dict.indexOf(st.split(" ")[0]));
      System.out.println(g.dist[dict.indexOf(st.split(" ")[1])]);
    }
  }

  static void constructGraph(Graph g, ArrayList<String> dict) {
    for (int i = 0; i < dict.size(); i++) {
      for (int j = 0; j < dict.size(); j++) {
        if (differsByOneLetter(dict.get(i), dict.get(j))) {
          g.addEdge(i, j);
        }
      }
    }
  }

  static boolean differsByOneLetter(String str1, String str2) {
    if (str1.length() != str2.length())
      return false;
    int same = 0;
    for (int i = 0; i < str1.length(); ++i) {
      if (str1.charAt(i) == str2.charAt(i))
        same++;
    }
    return same == str1.length() - 1;
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