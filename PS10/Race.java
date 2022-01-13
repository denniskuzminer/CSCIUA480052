// This code was adapted from https://www.geeksforgeeks.org/number-swaps-sort-adjacent-swapping-allowed/

import java.io.*;
import java.util.*;

class Race {
    static long merge(long arr[], long temp[], long left, long mid, long right) {
        long inv_count = 0;
        long i = left;
        long j = mid;
        long k = left;

        while ((i <= mid - 1) && (j <= right)) {
            if (arr[(int) i] <= arr[(int) j])
                temp[(int) k++] = arr[(int) i++];
            else {
                temp[(int) k++] = arr[(int) j++];
                inv_count = inv_count + (mid - i);
            }
        }
        while (i <= mid - 1)
            temp[(int) k++] = arr[(int) i++];
        while (j <= right)
            temp[(int) k++] = arr[(int) j++];

        for (i = left; i <= right; i++)
            arr[(int) i] = temp[(int) i];

        return inv_count;
    }

    static long _mergeSort(long arr[], long temp[], long left, long right) {
        long mid, inv_count = 0;
        if (right > left) {
            mid = (right + left) / 2;
            inv_count = _mergeSort(arr, temp, left, mid);

            inv_count += _mergeSort(arr, temp, mid + 1, right);

            inv_count += merge(arr, temp, left, mid + 1, right);
        }

        return inv_count;
    }

    static long countSwaps(long arr[], long n) {
        long temp[] = new long[(int) n];
        return _mergeSort(arr, temp, 0, n - 1);
    }

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS10/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        long len = Long.parseLong(br.readLine());
        long[] arr = new long[(int) len];
        String st = "";
        for (long i = 0; ((st = br.readLine()) != null); i++) {
            arr[(int) i] = Long.parseLong(st);
        }
        System.out.println(countSwaps(arr, arr.length));
    }
}