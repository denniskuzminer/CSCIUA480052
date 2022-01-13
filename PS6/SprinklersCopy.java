import java.io.*;
import java.util.*;

// Sprinklers
public class SprinklersCopy {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS6/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int[][] arr = new int[Integer.parseInt(st.split(" ")[0])][2];
        int len = Integer.parseInt(st.split(" ")[1]);
        int width = Integer.parseInt(st.split(" ")[2]);
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            arr[i][0] = Integer.parseInt(st.split(" ")[0]);
            arr[i][1] = Integer.parseInt(st.split(" ")[1]);
        }
        System.out.println(findMinSprinklers(arr, len, width));
    }

    public static int findMinSprinklers(int[][] arr, int len, int width) {
        int ans = 0;
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                if (entry1[0] > entry2[0])
                    return 1;
                else
                    return -1;
            }
        });
        // System.out.println(Arrays.deepToString(arr) + " " + len + " " + width);
        double currEdge = 0;
        boolean skip = false;
        for (int i = 0; i < arr.length; i++, skip = false) {
            int pos = arr[i][0];
            int rad = arr[i][1];
            if (rad <= .5 * width) {
                continue;
            }
            double circleReach = Math.sqrt(Math.pow(rad, 2) - Math.pow((.5 * width), 2));
            if (circleReach + pos >= currEdge && pos - circleReach <= currEdge) {
                // if the next one is not better
                if (i != arr.length - 1) {
                    for (int j = i + 1; j < arr.length; j++) {
                        double nextCircleReach = Math.sqrt(Math.pow(arr[j][1], 2) - Math.pow((.5 * width), 2));
                        if (arr[j][0] - nextCircleReach > currEdge) {
                            break;
                        }
                        if (nextCircleReach + arr[j][0] >= currEdge && arr[j][0] - nextCircleReach <= currEdge) {
                            i += i - j + 1;
                            skip = true;
                            // System.out.println(pos + " " + rad + " " + arr[j][0] + " " + arr[j][1]);
                            break;
                        } // found a better circle than all before

                    }
                }
                if (!skip) {
                    // System.out.println(pos + " " + rad + " " + currEdge);
                    currEdge = circleReach + pos;
                    ans++;
                }
            }
        }
        return ans == 0 || !(currEdge > len) ? -1 : ans;
    }
}

/*
 * if (i != arr.length - 1) { double nextCircleReach = Math.sqrt(Math.pow(arr[i
 * + 1][1], 2) - Math.pow((.5 * width), 2)); if (nextCircleReach + arr[i + 1][0]
 * >= currEdge && arr[i + 1][0] - nextCircleReach <= currEdge) continue; } if
 * (!(i >= arr.length - 2)) { double nextCircleReach = Math.sqrt(Math.pow(arr[i
 * + 2][1], 2) - Math.pow((.5 * width), 2)); if (nextCircleReach + arr[i + 2][0]
 * >= currEdge && arr[i + 2][0] - nextCircleReach <= currEdge) { i++; continue;
 * } } if (!(i >= arr.length - 3)) { double nextCircleReach =
 * Math.sqrt(Math.pow(arr[i + 3][1], 2) - Math.pow((.5 * width), 2)); if
 * (nextCircleReach + arr[i + 3][0] >= currEdge && arr[i + 3][0] -
 * nextCircleReach <= currEdge) { i += 2; continue; } } if (!(i >= arr.length -
 * 4)) { double nextCircleReach = Math.sqrt(Math.pow(arr[i + 4][1], 2) -
 * Math.pow((.5 * width), 2)); if (nextCircleReach + arr[i + 4][0] >= currEdge
 * && arr[i + 4][0] - nextCircleReach <= currEdge) { i += 2; continue; } } if
 * (!(i >= arr.length - 5)) { double nextCircleReach = Math.sqrt(Math.pow(arr[i
 * + 5][1], 2) - Math.pow((.5 * width), 2)); if (nextCircleReach + arr[i + 5][0]
 * >= currEdge && arr[i + 5][0] - nextCircleReach <= currEdge) { i += 2;
 * continue; } } if (!(i >= arr.length - 6)) { double nextCircleReach =
 * Math.sqrt(Math.pow(arr[i + 6][1], 2) - Math.pow((.5 * width), 2)); if
 * (nextCircleReach + arr[i + 6][0] >= currEdge && arr[i + 6][0] -
 * nextCircleReach <= currEdge) { i += 2; continue; } } if (!(i >= arr.length -
 * 7)) { double nextCircleReach = Math.sqrt(Math.pow(arr[i + 7][1], 2) -
 * Math.pow((.5 * width), 2)); if (nextCircleReach + arr[i + 7][0] >= currEdge
 * && arr[i + 7][0] - nextCircleReach <= currEdge) { i += 2; continue; } } if
 * (!(i >= arr.length - 8)) { double nextCircleReach = Math.sqrt(Math.pow(arr[i
 * + 8][1], 2) - Math.pow((.5 * width), 2)); if (nextCircleReach + arr[i + 8][0]
 * >= currEdge && arr[i + 8][0] - nextCircleReach <= currEdge) { i += 2;
 * continue; } } if (!(i >= arr.length - 9)) { double nextCircleReach =
 * Math.sqrt(Math.pow(arr[i + 9][1], 2) - Math.pow((.5 * width), 2)); if
 * (nextCircleReach + arr[i + 9][0] >= currEdge && arr[i + 9][0] -
 * nextCircleReach <= currEdge) { i += 2; continue; } } if (!(i >= arr.length -
 * 10)) { double nextCircleReach = Math.sqrt(Math.pow(arr[i + 10][1], 2) -
 * Math.pow((.5 * width), 2)); if (nextCircleReach + arr[i + 10][0] >= currEdge
 * && arr[i + 10][0] - nextCircleReach <= currEdge) { i += 2; continue; } }
 */