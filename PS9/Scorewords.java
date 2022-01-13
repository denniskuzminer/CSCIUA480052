import java.io.*;
import java.util.*;

public class Scorewords {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS9/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int m = Integer.parseInt(st.split(" ")[0]);
        int n = Integer.parseInt(st.split(" ")[1]);
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for (int i = 0; i < m && ((st = br.readLine()) != null); i++)
            dict.put(st.split(" ")[0], Integer.parseInt(st.split(" ")[1]));
        for (int j = 0; j < n; j++) {
            int score = 0;
            for (; ((st = br.readLine()) != null) && !st.equals(".");) {
                String[] line = st.split(" ");
                for (String word : line)
                    if (dict.containsKey(word))
                        score += dict.get(word);
            }
            System.out.println(score);
        }
    }
}