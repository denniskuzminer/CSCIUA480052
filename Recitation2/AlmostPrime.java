import java.io.*;
import java.util.*;

public class AlmostPrime {
    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation2/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        System.out.println(findAllAlmostPrime(Integer.parseInt(st)));
    }

    public static int findAllAlmostPrime(int num) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i <= num; i++) {
            if (isAlmostPrime(i)) {
                arr.add(i);
            }
        }
        return arr.size();
    }

    public static boolean isAlmostPrime(int num) {
        ArrayList<Integer> prime = new ArrayList<Integer>();

        for (int i = 2; i < num; i += 2) {
            while (num % i == 0) {
                num /= i;
                prime.add(i);
            }
            if (i == 2)
                i--;
        }

        return (new LinkedHashSet<>(prime)).size() == 2;
    }
}
