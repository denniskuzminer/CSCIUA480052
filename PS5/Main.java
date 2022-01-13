import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS5/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String input = "";
        String st = input;
        int n = Integer.parseInt(br.readLine());
        HashMap groups = new HashMap<>();
        Queue friends = new LinkedList<>();
        for (int i = 0; i < n && ((st = br.readLine()) != null); i++) {
            int[] arr = Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).toArray();
            Set<Integer> set = new HashSet<>();
            for (int j = 1; j < arr.length; j++) {
                groups.put(arr[j], i);
            }

        }
        // System.out.println(groups.toString());
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            if (st.split(" ")[0].equals("Push")) {
                Queue temp = new LinkedList<>();
                int num = Integer.parseInt(st.split(" ")[1]);

                if (friends.isEmpty()) {
                    temp.add(num);
                    friends.add(temp);
                } else {
                    // check which set the element belongs to
                    int set = (int) groups.get(num);
                    // if the element is in the same set as the top of a preexisting queue, then add
                    // it to that queue
                    boolean exists = false;
                    if (((Queue) friends.peek()).isEmpty()) {
                        friends.poll();
                    }
                    for (Object q : friends) {

                        Queue groupInLine = (Queue) q;

                        // System.out.println("group " + groupInLine.toString());
                        if (set == (int) groups.get(groupInLine.peek())) {
                            groupInLine.add(num);
                            exists = true;
                        }

                    }
                    if (!exists) {
                        temp.add(num);
                        friends.add(temp);
                    }
                    // else make a new queue at the end
                }
                // System.out.println(friends.toString());
            } else if (st.split(" ")[0].equals("Pop")) {
                if (((Queue) friends.peek()).isEmpty()) {
                    friends.poll();
                }
                // System.out.println(friends.toString());
                System.out.println(/* "Pop " + */((Queue) friends.peek()).poll());

            }

        }
        // int[] arr = Arrays.stream(br.readLine().split("
        // ")).mapToInt(Integer::parseInt).toArray();
        // System.out.println(function(input));
    }

    public static String function(String input) {
        return input;
    }
}