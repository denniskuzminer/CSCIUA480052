    import java.io.*;
    import java.util.*;

    public class Robot {
        public static void main(String args[]) throws Exception {
            File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/Recitation11/input.txt");
            // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st = "";
            for (; !((st = br.readLine()).equals("0 0 0"));) {
                char[][] grid = new char[Integer.parseInt(st.split(" ")[0])][Integer.parseInt(st.split(" ")[1])];
                int start = Integer.parseInt(st.split(" ")[2]) - 1;
                for (int i = 0; i < grid.length && (st = br.readLine()) != null; i++)
                    grid[i] = st.toCharArray();
                System.out.println(findExitTime(grid, start));
            }
        }

        public static String findExitTime(char[][] grid, int start) {
            int row = 0, count = 0, col = start;
            HashMap<String, Integer> visited = new HashMap<String, Integer>();
            while ((row < grid.length && row >= 0) && (col < grid[0].length && col >= 0)) {
                if (visited.containsKey(row + " " + col)) {
                    return visited.get(row + " " + col) - 1 + " step(s) before a loop of "
                            + (1 + count - visited.get(row + " " + col)) + " step(s)";
                }
                visited.put(row + " " + col, ++count);
                if (grid[row][col] == 'N') {
                    row--;
                    continue;
                }
                if (grid[row][col] == 'S') {
                    row++;
                    continue;
                }
                if (grid[row][col] == 'W') {
                    col--;
                    continue;
                }
                if (grid[row][col] == 'E') {
                    col++;
                    continue;
                }
            }
            return count + " step(s) to exit";
        }
    }