import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Sum {

    static Set<String> ans = new HashSet<String>();

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS6/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String input = br.readLine();
        int t = Integer.parseInt(input.split(" ")[0]);
        int check = Integer.parseInt(input.split(" ")[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sum(arr, arr.length, t, 0, 0, "");
        if (check != 0) {
            List<List<Integer>> s = new ArrayList<List<Integer>>();
            ans.forEach(str -> {
                var list = Arrays.stream(str.substring(1).split(",")).mapToInt(Integer::parseInt).mapToObj(i -> i)
                        .collect(Collectors.toList());
                Collections.sort(list, Collections.reverseOrder());
                s.add(list);
            });

            Collections.sort(s, new ListComparator<>());
            System.out.println("Sums of " + t + ":");
            if (ans.isEmpty()) {
                System.out.println("NONE");
            } else {
                for (int i = s.size() - 1; i >= 0; i--) {
                    if (!(i != s.size() - 1 && s.get(i).equals(s.get(i + 1))))
                        System.out.println(s.get(i).toString().replace(", ", "+").replace("]", "").replace("[", ""));
                }
            }
        }
    }

    public static void sum(int[] a, int n, int t, int i, int sum, String curr) {
        if (i == n) {
            if (sum == t) {
                ans.add(curr);
            }
            return;
        }
        sum(a, n, t, i + 1, sum + a[i], curr + "," + a[i]);
        sum(a, n, t, i + 1, sum, curr);
    }
}

// This code was taken from
// https://stackoverflow.com/questions/35761864/java-sort-list-of-lists

class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {

    @Override
    public int compare(List<T> o1, List<T> o2) {
        for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
            int c = o1.get(i).compareTo(o2.get(i));
            if (c != 0) {
                return c;
            }
        }
        return Integer.compare(o1.size(), o2.size());
    }

}

// 20 12
// 1 12 3 4 5 6 7 8 9 20 10 11

// 1000 6
// 10 100 900 50 40 50