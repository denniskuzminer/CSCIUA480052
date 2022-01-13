import java.io.*;
import java.util.*;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static ArrayList<String> possibleIO = new ArrayList<String>();
    static int n;

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS3/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        String initWord = st;
        st = br.readLine();
        String ans = st;
        printIO(initWord, ans);
        // System.out.println(Stream.of("edcba".split("")).sorted().collect(Collectors.joining()));

    }

    public static void printIO(String initWord, String ans) {
        String sortedInit = Stream.of(initWord.split("")).sorted().collect(Collectors.joining());
        String sortedAns = Stream.of(ans.split("")).sorted().collect(Collectors.joining());
        if (!sortedInit.equals(sortedAns)) {
            System.out.println("[\n]");
            return;
        }
        n = initWord.length();
        // String temp = "";
        char[] set2 = { 'i', 'o' };
        printAllKLength(set2, 2 * initWord.length());
        possibleIO.removeIf(s -> {
            int counti = 0;
            int counto = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'i') {
                    counti++;
                }
                if (s.charAt(i) == 'o') {
                    counto++;
                }
                if (counto > counti) {
                    return true;
                }
                if (counti > n) {
                    return true;
                }
            }
            return false;
        });
        possibleIO.removeIf(s -> {
            Stack<Character> stack = new Stack<Character>();
            ArrayList<Character> temp = new ArrayList<Character>();
            for (int i = 0, j = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'i') {
                    stack.push(ans.charAt(j));
                    j++;
                }
                if (s.charAt(i) == 'o') {
                    temp.add(stack.pop());
                }
            }
            // System.out.println(stack.toString());
            if (!temp.stream().map(e -> e.toString()).collect(Collectors.joining()).equals(ans)) {
                return true;
            }
            return false;
        });
        for (int i = 0; i < possibleIO.size(); i++) {
            possibleIO.set(i, possibleIO.get(i).replace("", " "));
        }
        System.out.println(
                possibleIO.toString().replace("[", "[\n").replace("]", "\n]").replace(", ", "\n").replace("\n ", "\n"));
    }

    public static void printAllKLength(char[] set, int k) {
        int n = set.length;
        printAllKLengthRec(set, "", n, k);
    }

    public static void printAllKLengthRec(char[] set, String prefix, int n, int k) {
        if (k == 0) {
            possibleIO.add(prefix);
            return;
        }
        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + set[i];
            printAllKLengthRec(set, newPrefix, n, k - 1);
        }
    }

}