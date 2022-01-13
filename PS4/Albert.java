import java.io.*;
import java.util.*;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Albert {

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS4/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String input = "";
        String st;
        for (; (st = br.readLine()) != null;) {
            input += st + "\n";
        }
        // System.out.println("121()* &* abc *awre@#".replaceAll("[^a-zA-Z]", "
        // ").split(" "));
        unique(input);
    }

    public static void unique(String input) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        String[] onlyWords = input.replaceAll("[^a-zA-Z]", " ").split(" ");
        for (String word : onlyWords) {
            if (!word.equals("")) {
                hm.put(word.toLowerCase(), 0);
            }
        }

        // https://stackoverflow.com/questions/22391350/how-to-sort-a-hashset
        TreeSet myTreeSet = new TreeSet();
        myTreeSet.addAll(hm.keySet());

        for (Object string : myTreeSet) {
            System.out.println(string);
        }
    }
}