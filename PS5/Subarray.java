import java.io.*;
import java.util.*;

public class Subarray {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS5/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(findMaxSubArray2(arr));
    }

    public static int findMaxSubArray2(int[] arr) {
        int ans = 0;
        int temp = 0;
        HashMap<Integer, Integer> checkUnique = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (!checkUnique.containsKey(arr[i])) {
                temp++;
                checkUnique.put(arr[i], i);
            } else {
                if (temp > ans) {
                    ans = temp;
                }
                i = checkUnique.get(arr[i]);
                checkUnique.clear();
                temp = 0;
            }
            if (temp > ans) {
                ans = temp;
            }

        }
        return ans;
    }

    public static int findMaxSubArray1(int[] arr) {
        int ans = 0;
        int temp = 0;
        Arrays.sort(arr);
        HashMap<Integer, Integer> checkUnique = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j >= i) {
                    if (!checkUnique.containsKey(arr[j])) {
                        temp++;
                        checkUnique.put(arr[j], 0);
                    } else {
                        if (temp > ans) {
                            ans = temp;
                        }
                        checkUnique.clear();
                        temp = 0;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static int findMaxSubArray(int[] arr) {
        int temp = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Arrays.sort(arr);
        HashMap<Integer, Integer> checkUnique = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                ans.add(temp);
                temp = 0;
            } else {
                temp++;
            }
            if (i == arr.length - 2) {
                ans.add(temp);
            }
        }
        return Collections.max(ans) + 1;
    }

}