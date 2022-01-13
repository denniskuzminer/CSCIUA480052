import java.util.Scanner;

public class Add {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(add(a, b));
    }

    public static int add(int a, int b) {
        return a + b;
    }
}