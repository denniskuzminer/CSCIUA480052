import java.io.*;
import java.util.*;

class CodeChefChess {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        String st;
        for (int i = 0; (i < cases); i++) {
            st = br.readLine();
            int[] arr = Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (arr[0] == arr[2] && arr[1] == arr[3])
                System.out.println("0");
            else if (((arr[0] + arr[1]) % 2 == 0 && (arr[2] + arr[3]) % 2 == 1)
                    || ((arr[0] + arr[1]) % 2 == 1 && (arr[2] + arr[3]) % 2 == 0))
                System.out.println("1");
            else if (((arr[0] + arr[1]) % 2 == 0 && (arr[2] + arr[3]) % 2 == 0)
                    || ((arr[0] + arr[1]) % 2 == 1 && (arr[2] + arr[3]) % 2 == 1))
                System.out.println("2");
        }
    }
}

// https://www.codechef.com/START17C/problems/NEWPIECE
// https://www.codechef.com/viewsolution/53943600