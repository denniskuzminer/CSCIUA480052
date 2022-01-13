import java.util.Scanner;

public class Add2 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        System.out.println(add(a, b));
    }

    public static long add(long a, long b) {
        return a + b;
    }
}