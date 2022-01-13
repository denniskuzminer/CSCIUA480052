import java.io.*;
import java.util.*;

public class Adding {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS8/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();
        var arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).boxed()
                .collect(java.util.stream.Collectors.toList());
        System.out.println(minSum(arr));
    }

    public static long minSum(List<Long> arr) {
        PriorityQueue<Long> nums = new PriorityQueue<Long>(arr);
        long sum = 0, minSum = 0;
        for (; nums.size() > 1;) {
            long top1 = nums.poll();
            long top2 = nums.poll();
            nums.add(top1 + top2);
            sum += (top1 + top2);
        }
        return sum;
    }
}