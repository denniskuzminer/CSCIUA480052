// This code was adapted from https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/ 

import java.io.*;
import java.util.*;

public class Matches {

    int st[];
    boolean max;

    Matches(int arr[], int n, boolean max) {
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        this.max = max;
        st = new int[max_size];
        if (!max) {
            Arrays.fill(st, Integer.MAX_VALUE);
        }
        constructSTUtil(arr, 0, n - 1, 0);
    }

    int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    int getSumUtil(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se)
            return st[si];
        if (se < qs || ss > qe)
            return max ? 0 : Integer.MAX_VALUE;
        int mid = getMid(ss, se);
        return max ? Math.max(getSumUtil(ss, mid, qs, qe, 2 * si + 1), getSumUtil(mid + 1, se, qs, qe, 2 * si + 2))
                : Math.min(getSumUtil(ss, mid, qs, qe, 2 * si + 1), getSumUtil(mid + 1, se, qs, qe, 2 * si + 2));
    }

    void updateValueUtil(int ss, int se, int i, int diff, int si) {
        if (i < ss || i > se)
            return;
        st[si] = st[si] + diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    void updateValue(int arr[], int n, int i, int new_val) {
        if (i < 0 || i > n - 1) {
            return;
        }
        int diff = new_val - arr[i];
        arr[i] = new_val;
        updateValueUtil(0, n - 1, i, diff, 0);
    }

    int getSum(int n, int qs, int qe) {
        if (qs < 0 || qe > n - 1 || qs > qe) {
            return -1;
        }
        return getSumUtil(0, n - 1, qs, qe, 0);
    }

    int constructSTUtil(int arr[], int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
        int mid = getMid(ss, se);
        st[si] = max
                ? Math.max(constructSTUtil(arr, ss, mid, si * 2 + 1), constructSTUtil(arr, mid + 1, se, si * 2 + 2))
                : Math.min(constructSTUtil(arr, ss, mid, si * 2 + 1), constructSTUtil(arr, mid + 1, se, si * 2 + 2));
        return st[si];
    }

    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp
        // Sci/CSCIUA480052/Recitation12/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Matches maxMatches = new Matches(arr, arr.length, true);
        Matches minMatches = new Matches(arr, arr.length, false);
        br.readLine();
        for (; ((st = br.readLine()) != null);) {
            int L = Integer.parseInt(st.split(" ")[0]);
            int R = Integer.parseInt(st.split(" ")[1]);
            System.out.println(minMatches.getSum(arr.length, L, R) + Math.max(
                    ((double) (maxMatches.getSum(arr.length, L, R) - minMatches.getSum(arr.length, L, R))) / 2,
                    Math.max(maxMatches.getSum(arr.length, 0, L - 1),
                            maxMatches.getSum(arr.length, R + 1, arr.length - 1))));
        }
    }
}