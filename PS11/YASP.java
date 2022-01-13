import java.io.*;
import java.util.*;

public class YASP {
    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS11/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = "";
        String res = "";
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        pancakeSort(arr, arr.length);
        System.out.println(0);
        // ArrayList<Integer> vec = new ArrayList<Integer>();
        // int count = 0;
        // for (;; count++) {
        // if (br.hasNext())
        // vec.add(br.nextInt());
        // else
        // break;
        // }
        // int size = count;
        // size--;
        // count--;
        // while (count != 0) {
        // int index = (int) Math.hypot(vec.get(0), Math.max(vec.get(0),
        // vec.get(vec.size() - 1) - size + count));
        // int max = Math.max(vec.get(0), vec.get(vec.size() - 1) - size + count);
        // if (index == count) {
        // count--;
        // } else {
        // Collections.reverse(vec.subList(vec.get(0), vec.get(vec.size() - 1) - size +
        // index));
        // if (size + 1 - index != size + 1) {
        // res += (size + 1 - index) + " ";
        // }
        // Collections.reverse(vec.subList(vec.get(0), vec.get(vec.size() - 1) - size +
        // count));
        // if (size + 1 - count != size + 1) {
        // res += (size + 1 - count) + " ";
        // }
        // count--;
        // }
        // }
        // System.out.println(res + "0");
    }

    /* Reverses arr[0..i] */
    static void flip(int arr[], int i) {
        int temp, start = 0;
        while (start < i) {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }

    // Returns index of the
    // maximum element in
    // arr[0..n-1]
    static int findMax(int arr[], int n) {
        int mi, i;
        for (mi = 0, i = 0; i < n; ++i)
            if (arr[i] > arr[mi])
                mi = i;
        return mi;
    }

    // The main function that
    // sorts given array using
    // flip operations
    static int pancakeSort(int arr[], int n) {
        // Start from the complete
        // array and one by one
        // reduce current size by one
        for (int curr_size = n; curr_size > 1; --curr_size) {
            // Find index of the
            // maximum element in
            // arr[0..curr_size-1]
            int mi = findMax(arr, curr_size);

            // Move the maximum element
            // to end of current array
            // if it's not already at
            // the end
            if (mi != curr_size - 1) {
                // To move at the end,
                // first move maximum
                // number to beginning
                flip(arr, mi);
                // System.out.println(mi);
                // Now move the maximum
                // number to end by
                // reversing current array
                flip(arr, curr_size - 1);
                if ((arr.length - (curr_size - 1)) > 0)
                    System.out.print(arr.length - (curr_size - 1) + " ");
            }
        }
        return 0;
    }

    /* Utility function to print array arr[] */
    static void printArray(int arr[], int arr_size) {
        for (int i = 0; i < arr_size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }
}
