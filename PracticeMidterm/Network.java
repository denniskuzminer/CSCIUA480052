import java.io.*;
import java.util.*;

public class Network {
    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PracticeMidterm/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = "";
        int fail = 0;
        int success = 0;
        var graph = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            String[] arr = st.split(" ");
            if (arr[0].equals("c")) {
                int from = Integer.parseInt(arr[1]);
                int to = Integer.parseInt(arr[2]);
                if (!graph.containsKey(from)) {
                    graph.put(from, new HashSet<Integer>());
                    graph.get(from).add(from);
                }
                if (!graph.containsKey(to)) {
                    graph.put(to, new HashSet<Integer>());
                    graph.get(to).add(to);
                }
                graph.get(from).add(to);
                graph.get(to).add(from);
            }
            if (arr[0].equals("q")) {
                if (existsConnection(graph, Integer.parseInt(arr[1]), Integer.parseInt(arr[2]))) {
                    success++;
                } else {
                    fail++;
                }
            }
        }
        System.out.println(graph.toString());
        System.out.println(success + "," + fail);
        // int[] arr = Arrays.stream(br.readLine().split("
        // ")).mapToInt(Integer::parseInt).toArray();
    }

    public static boolean existsConnection(HashMap<Integer, HashSet<Integer>> graph, int start, int end) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return false;
        }
        if (graph.get(start).contains(end) || graph.get(end).contains(start)) {
            return true;
        } else {
            boolean exists = false;
            for (int i = 0; i < array.length; i++) {
                
            }
            return exists;
        }
    }
}