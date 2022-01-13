import java.io.*;
import java.util.*;
import static java.lang.Math.sqrt;
import static java.lang.Math.floor;

// This code is adapted from geeksforgeeks.org/segmented-sieve-print-primes-in-a-range/
public class Prime {

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS4/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String input = br.readLine();
        int low = Integer.parseInt(input.split(" ")[0]);
        long high = Long.parseLong(input.split(" ")[1]);
        // segmentedSieve(low, high);
        // boolean isPrime[] = new boolean[1147483647];
        // boolean isPrime[] = new boolean[1147483647];
        // 2147483648/2=1073741824
        System.out.println(primeGaps2(low, high));
    }

    public static String primeGaps2(int low, long high) {
        ArrayList<Integer> primesInRange = new ArrayList<Integer>();
        // Sieve of Eratosthenes (may have been taken from GeeksForGeeks)
        // boolean isPrime[] = new boolean[high + 1];
        // Arrays.fill(isPrime, true);
        // isPrime[0] = isPrime[1] = false;
        HashMap<Long, Boolean> isPrime = new HashMap<Long, Boolean>();

        isPrime.put((long) 1, true);
        isPrime.put((long) 0, true);
        for (long i = 2; i <= high; i++) {
            if (!isPrime.containsKey(i) || !isPrime.get(i)) {
                for (long j = i; j <= high; j += i) {
                    if (j != i)
                        isPrime.put(j, true);
                }
            }
        }
        for (int i = 1; i <= high; i += 1) {
            if (!isPrime.containsKey(i) || !isPrime.get(i))
                if (low <= i && i <= high)
                    primesInRange.add(i);
        }

        if (primesInRange.isEmpty() || primesInRange.size() < 2) {
            return "-1";
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        String minNums = "";
        String maxNums = "";
        for (int i = 0; i < primesInRange.size() - 1; i++) {
            int diff = primesInRange.get(i + 1) - primesInRange.get(i);
            if (diff < min) {
                min = diff;
                minNums = primesInRange.get(i) + " " + primesInRange.get(i + 1);
            }
            if (diff > max) {
                max = diff;
                maxNums = primesInRange.get(i) + " " + primesInRange.get(i + 1);
            }
        }

        return minNums + " " + maxNums;
    }

    public static String primeGaps(int low, int high) {
        ArrayList<Integer> primesInRange = new ArrayList<Integer>();
        // Sieve of Eratosthenes (may have been taken from GeeksForGeeks)
        boolean isPrime[] = new boolean[high + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= high; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= high; j += i) {
                    if (j != i)
                        isPrime[j] = false;
                }
            }
        }
        for (int i = 1; i <= high; i += 1) {
            if (isPrime[i] == true)
                if (low <= i && i <= high)
                    primesInRange.add(i);
        }

        if (primesInRange.isEmpty() || primesInRange.size() < 2) {
            return "-1";
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        String minNums = "";
        String maxNums = "";
        for (int i = 0; i < primesInRange.size() - 1; i++) {
            int diff = primesInRange.get(i + 1) - primesInRange.get(i);
            if (diff < min) {
                min = diff;
                minNums = primesInRange.get(i) + " " + primesInRange.get(i + 1);
            }
            if (diff > max) {
                max = diff;
                maxNums = primesInRange.get(i) + " " + primesInRange.get(i + 1);
            }
        }

        return minNums + " " + maxNums;
    }

    public static String primeGaps1(int low, int high) {
        ArrayList<Integer> primesInRange = new ArrayList<Integer>();
        ArrayList<Integer> chprime = new ArrayList<Integer>();
        boolean[] ck = new boolean[high];
        Arrays.fill(ck, true);
        ck[1] = false;
        ck[0] = false;

        for (int i = 2; (i * i) <= high; i++) {
            if (ck[i] == true) {
                for (int j = i * i; j < high; j = j + i) {
                    ck[j] = false;
                }
            }
        }
        for (int i = 2; i * i <= high; i++) {
            if (ck[i] == true) {
                // cout<< i<<"\n";
                chprime.add(i);
            }
        }
        boolean[] prime = new boolean[high - low + 1];
        Arrays.fill(prime, true);
        // here prime[0] indicates whether low is prime or not similarly prime[1]
        // indicates whether low+1 is prime or not
        for (int i : chprime) {
            int lower = (low / i);
            // here lower means the first multiple of prime which is in range [low,high]
            // for eg: 3's first multiple in range [28,40] is 30
            if (lower <= 1) {
                lower = i + i;
            } else if (low % i != 0) {
                lower = (lower * i) + i;
            } else {
                lower = (lower * i);
            }
            for (int j = lower; j <= high; j = j + i) {
                prime[j - low] = false;
            }
        }
        for (int i = low; i <= high; i++) {
            if (prime[i - low] == true) {
                primesInRange.add(i);
            }
        }
        if (primesInRange.isEmpty() || primesInRange.size() < 2) {
            return "-1";
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        String minNums = "";
        String maxNums = "";
        for (int i = 0; i < primesInRange.size() - 1; i++) {
            int diff = primesInRange.get(i + 1) - primesInRange.get(i);
            if (diff < min) {
                min = diff;
                minNums = primesInRange.get(i) + " " + primesInRange.get(i + 1);
            }
            if (diff > max) {
                max = diff;
                maxNums = primesInRange.get(i) + " " + primesInRange.get(i + 1);
            }
        }

        return minNums + " " + maxNums;
    }

    static void simpleSieve(int limit, Vector<Integer> prime) {
        // Create a boolean array "mark[0..n-1]" and initialize
        // all entries of it as true. A value in mark[p] will
        // finally be false if 'p' is Not a prime, else true.
        boolean mark[] = new boolean[limit + 1];

        for (int i = 0; i < mark.length; i++)
            mark[i] = true;

        for (int p = 2; p * p < limit; p++) {
            // If p is not changed, then it is a prime
            if (mark[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i < limit; i += p)
                    mark[i] = false;
            }
        }

        // Print all prime numbers and store them in prime
        for (int p = 2; p < limit; p++) {
            if (mark[p] == true) {
                prime.add(p);
                System.out.print(p + "  ");
            }
        }
    }

    // Prints all prime numbers smaller than 'n'
    static void segmentedSieve(int n) {
        // Compute all primes smaller than or equal
        // to square root of n using simple sieve
        int limit = (int) (floor(sqrt(n)) + 1);
        Vector<Integer> prime = new Vector<>();
        simpleSieve(limit, prime);

        // Divide the range [0..n-1] in different segments
        // We have chosen segment size as sqrt(n).
        int low = limit;
        int high = 2 * limit;

        // While all segments of range [0..n-1] are not processed,
        // process one segment at a time
        while (low < n) {
            if (high >= n)
                high = n;

            // To mark primes in current range. A value in mark[i]
            // will finally be false if 'i-low' is Not a prime,
            // else true.
            boolean mark[] = new boolean[limit + 1];

            for (int i = 0; i < mark.length; i++)
                mark[i] = true;

            // Use the found primes by simpleSieve() to find
            // primes in current range
            for (int i = 0; i < prime.size(); i++) {
                // Find the minimum number in [low..high] that is
                // a multiple of prime.get(i) (divisible by prime.get(i))
                // For example, if low is 31 and prime.get(i) is 3,
                // we start with 33.
                int loLim = (int) (floor(low / prime.get(i)) * prime.get(i));
                if (loLim < low)
                    loLim += prime.get(i);

                /*
                 * Mark multiples of prime.get(i) in [low..high]: We are marking j - low for j,
                 * i.e. each number in range [low, high] is mapped to [0, high-low] so if range
                 * is [50, 100] marking 50 corresponds to marking 0, marking 51 corresponds to 1
                 * and so on. In this way we need to allocate space only for range
                 */
                for (int j = loLim; j < high; j += prime.get(i))
                    mark[j - low] = false;
            }

            // Numbers which are not marked as false are prime
            for (int i = low; i < high; i++)
                if (mark[i - low] == true)
                    System.out.print(i + "  ");

            // Update low and high for next segment
            low = low + limit;
            high = high + limit;
        }
    }
}