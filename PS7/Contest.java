import java.io.*;
import java.util.*;

class Contest {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        int n = Integer.parseInt(st);
        for (int i = 0; i < n; i++) {
            String alpha = br.readLine();
            String target = br.readLine();
            boolean isSame = true;
            int sum = 0;
            for (int j = 0; j < target.length(); j++) {
                isSame = isSame && (target.charAt(j) == target.charAt(0));
            }
            if (isSame) {
                System.out.println(0);
            } else {
                for (int j = 1; j < target.length(); j++) {
                    int curr = j;
                    int prev = j - 1;
                    sum += Math.abs(alpha.indexOf(target.charAt(curr)) - alpha.indexOf(target.charAt(prev)));
                }
                System.out.println(sum);
            }

        }
    }
}