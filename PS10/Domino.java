import java.io.*;
import java.util.*;

public class Domino {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS10/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int[] events = new int[1 + Integer.parseInt(st)];
        for (int i = 1; ((st = br.readLine()) != null); i++) {
            events[i] = Integer.parseInt(st);
        }
        System.out.println(findLongestChain(events));
    }

    public static int findLongestChain(int[] events) {
        boolean[] visited = new boolean[events.length];
        int max = Integer.MIN_VALUE, maxEvent = Integer.MAX_VALUE;
        for (int i = 0, currCount = 0; i < events.length; i++, visited = new boolean[events.length]) {
            currCount = 0;
            for (int curr = i; !visited[curr]; visited[curr] = true, curr = events[curr], currCount++) {
            }
            // System.out.println("At " + i + " the depth is " + currCount);
            if (currCount > max) {
                max = currCount;
                maxEvent = i;
            }
            if (currCount == max)
                maxEvent = Math.min(i, maxEvent);
        }
        return maxEvent;
    }
}