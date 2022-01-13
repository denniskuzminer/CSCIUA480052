import java.io.*;
import java.util.*;

public class ParityGame {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String from = br.readLine();
        String to = br.readLine();
        int from1s = from.length() - from.replace("1", "").length();
        int to1s = to.length() - to.replace("1", "").length();
        System.out
                .println(from1s % 2 == 0 && to1s > from1s ? "NO" : from1s % 2 == 1 && to1s > from1s + 1 ? "NO" : "YES");
    }
}