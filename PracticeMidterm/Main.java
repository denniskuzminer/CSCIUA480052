import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PracticeMidterm/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = "";
        ArrayList<List<Integer>> input = new ArrayList<List<Integer>>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            if (st.equals("#")) {
                break;
            }
            // System.out.println(st.substring(8));
            input.add(Arrays.stream(st.substring(9).split(" ")).mapToInt(Integer::parseInt).boxed()
                    .collect(Collectors.toList()));
            if (Integer.parseInt(st.substring(9).split(" ")[1]) > max) {
                max = Integer.parseInt(st.substring(9).split(" ")[1]);
            }
        }
        int times = Integer.parseInt(br.readLine());
        System.out.print(getAlerts(input, times, max));
    }

    public static String getAlerts(ArrayList<List<Integer>> input, int times, int max) {
        String[] ans = new String[max * times];
        for (var time : input) {
            int id = time.get(0);
            int interval = time.get(1);
            for (int i = interval; i <= ans.length; i += interval) {
                ans[i - 1] += " " + id;
            }
        }
        String sol = "";
        int freq = 0;
        for (String string : ans) {
            if (string != null) {
                if (string.split(" ").length > 2) {
                    for (String id : string.split(" ")) {
                        if (freq >= times)
                            return sol;
                        if (!id.equals("null")) {
                            sol += id + "\n";
                            freq++;
                        }
                    }
                } else {
                    if (freq >= times)
                        return sol;
                    sol += string.split(" ")[1] + "\n";
                    freq++;
                }
            }
        }
        return sol;
        // return "-1";
    }
}