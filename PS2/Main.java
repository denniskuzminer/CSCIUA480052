import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        String input = "";
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS2/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        input = st;
        int converted = convert(Integer.parseInt(input));
        System.out.print(input + " converts to " + converted);
    }

    public static int convert(int input) {
        return ByteBuffer.allocate(4).putInt(input).order(ByteOrder.nativeOrder()).getInt(0);

    }

}