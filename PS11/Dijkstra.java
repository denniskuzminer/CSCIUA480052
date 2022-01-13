// import java.util.*;
// import java.io.*;

// class Main {

// int v;
// int[][] edges;

// // void dijkstra() {

// // distance[x] = 0
// // q.push ( {0,x} )
// // while q is not empty
// // {d,a} = q.pop()
// // if visited[a] continue
// // visited[a] = true
// // for u in adj[a]
// // if distance[a]+u.w < distance[u.b]
// // distance[u.b] = distance[a] + u.w
// // q.push( { -distance[u.b], u.b} )
// // }

// public static void main(String[] args) throws Exception {
// File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS11/input.txt");
// // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// BufferedReader br = new BufferedReader(new FileReader(file));
// String st = "";
// int[] arr = Arrays.stream(br.readLine().split("
// ")).mapToInt(Integer::parseInt).toArray();
// int n = arr[0];
// int E = arr[1];
// int B = arr[2];
// HashMap
// Object[] graph = new Object[n];
// for (int i = 0; ((st = br.readLine()) != null); i++) {

// graph[Integer.parseInt(st.split(" ")[0]) - 1].w = Integer.parseInt(st.split("
// ")[1]) - 1;
// graph[Integer.parseInt(st.split(" ")[0]) - 1].b = Integer.parseInt(st.split("
// ")[2]);
// }
// }
// }
