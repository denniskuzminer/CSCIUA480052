// The code used to compute prime pairs was a modification of the code in https://www.geeksforgeeks.org/twin-prime-numbers-between-1-and-n/ 

import java.io.*;
import java.util.*;

public class Prime {

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS9/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        int input = Integer.parseInt(br.readLine());
        System.out.println(getPrimePair(20000000, input, new ArrayList<String>()));
    }

    public static String getPrimePair(int n, int index, ArrayList<String> list) {
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;
        for (int p = 2; p * p <= n; p++)
            if (prime[p] == true)
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
        for (int i = 2; i <= n - 2; i++)
            if (prime[i] == true && prime[i + 2] == true)
                list.add("(" + i + ", " + (i + 2) + ")");
        return list.get(index - 1);
    }
}
