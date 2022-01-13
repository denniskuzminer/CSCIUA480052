// import java.io.*;
// import java.util.*;

// public class KickStart1 {
//     static Set<Integer> valid = new HashSet<Integer>();

//     public static void main(String args[]) throws Exception {
//         File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS9/input.txt");
//         BufferedReader br = new BufferedReader(new FileReader(file));
//         // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         for (int i = 0; i < 10; i++) {
//             valid.add(i * 1000 + ((i + 1) % 10));
//         }
//         int t = Integer.parseInt(br.readLine());
//         for (int i = 0; i < t; i++) {
//             br.readLine();
//             String ans = br.readLine();
//             String initAns = ans;
//             while (ans.contains("01") || ans.contains("12") || ans.contains("23") || ans.contains("34")
//                     || ans.contains("45") || ans.contains("56") || ans.contains("67") || ans.contains("78")
//                     || ans.contains("89") || ans.contains("90")) {
//                 for (int j = 0; j < initAns.length() - 1; j++) {
//                     String sub = initAns.substring(j, j + 2);
//                     int mapped = map(sub);
//                     // System.out.println(sub + " " + mapped);
//                     if (valid.contains(mapped)) {
//                         ans = ans.replace(sub, ((1 + mapped % 1000) % 10) + "");
//                     }
//                 }
//                 System.out.println(ans);
//             }
//             System.out.println("Case #" + (i + 1) + ": " + ans);
//         }
//     }

//     public static int map(String s) {
//         return Integer.parseInt(s.charAt(0) + "") * 1000 + Integer.parseInt(s.charAt(1) + "");
//     }
// }

import java.io.*;
import java.util.*;

public class KickStart1 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] from = { "01", "12", "23", "34", "45", "56", "67", "78", "89", "90" };
        String[] to = { "2", "3", "4", "5", "6", "7", "8", "9", "0", "1" };
        for (int i = 0; i < t; i++) {
            br.readLine();
            String ans = br.readLine();
            while (containsSubstring(ans)) {
                for (int j = 0; j < to.length; j++) {
                    ans = fastReplace(ans, from[j], to[j]);
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + ans);
        }
    }

    public static boolean containsSubstring(String s) {
        return s.contains("01") || s.contains("12") || s.contains("23") || s.contains("34") || s.contains("45")
                || s.contains("56") || s.contains("67") || s.contains("78") || s.contains("89") || s.contains("90");
    }

    public static String fastReplace(String str, String target, String replacement) {
        int targetLength = target.length();
        if (targetLength == 0) {
            return str;
        }
        int idx2 = str.indexOf(target);
        if (idx2 < 0) {
            return str;
        }
        StringBuilder buffer = new StringBuilder(targetLength > replacement.length() ? str.length() : str.length() * 2);
        int idx1 = 0;
        do {
            buffer.append(str, idx1, idx2);
            buffer.append(replacement);
            idx1 = idx2 + targetLength;
            idx2 = str.indexOf(target, idx1);
        } while (idx2 > 0);
        buffer.append(str, idx1, str.length());
        return buffer.toString();
    }
}