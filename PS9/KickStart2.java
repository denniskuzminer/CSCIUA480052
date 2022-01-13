import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class KickStart2 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            String f = br.readLine();
            int numOp = 0;
            Set<Character> fSet = f.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
            for (Character ch : s.toCharArray()) {
                char up = ch;
                char down = ch;
                while (!(fSet.contains(up) || fSet.contains(down))) {
                    numOp++;
                    up++;
                    down--;
                    if (down < 97) {
                        down = 'z';
                    }
                    if (up > 122) {
                        up = 'a';
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + numOp);
        }
    }
}

// https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435914/00000000008da461