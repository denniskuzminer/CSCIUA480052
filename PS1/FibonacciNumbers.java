import java.util.Scanner;

public class FibonacciNumbers {
    public static void main(String args[]) {
        // Scanner in = new Scanner(System.in);
        // int n = in.nextInt();
        System.out.println(fib(80));
    }

    public static long fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}