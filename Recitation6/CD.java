// import java.io.*;
// import java.util.*;

// public class CD {
// public static void main(String args[]) throws Exception {
// File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation
// 6/input.txt");
// // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// BufferedReader br = new BufferedReader(new FileReader(file));
// String input = "";
// String st = input;
// for (int i = 0; ((st = br.readLine()) != null); i++) {
// input += st + " ";
// }
// // int[] arr = Arrays.stream(br.readLine().split("
// // ")).mapToInt(Integer::parseInt).toArray();
// rec(0, 0, "");
// }

// public static void rec(int i, int sum, String curr) {
// if (sum == target) {
// return perm;
// }
// if (sum > bestSum && sum < target) {
// bestSum = sum;
// bestPerm = perm;
// }
// if (sum > target) {
// return;
// }

// rec(j, sum + CD[i], perm + CD[i]);
// rec(j, sum, perm);
// }
// }