import java.io.*;
import java.util.*;

public class Awesome {
    public static void main(String args[]) throws Exception {
        String input = "";
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS3/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        input = st;
        int converted = convert(Integer.parseInt(input));
        System.out.println(converted);
    }

    public static int convert(int n) {
        int numAwesome = 0;
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= n; j += i) {
                    if (j != i)
                        isPrime[j] = false;
                }
            }
        }

        for (int i = 1; i <= n; i += 10) {
            if (i % 10 == 1 && i != 1 && isPrime[i] == true)
                numAwesome++;
        }
        return numAwesome;
    }

    public static boolean isPrime(int num) {
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

}