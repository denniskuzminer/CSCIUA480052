import java.util.*;

class Chess {
    public static void main(String[] args) {
        Chess c = new Chess();
        System.out.println(c.getQueensArrangements(3));
    }

    public ArrayList<ArrayList<String>> getQueensArrangements(int N) {
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        EightQueens query = new EightQueens(N, ans);
        boolean solnExists = query.findSolution(0);
        return ans;
    }
}

class EightQueens {
    public boolean[][] board;
    public boolean[] upDiagEmpty;
    public boolean[] downDiagEmpty;
    public boolean[] colEmpty;
    public int n;
    public ArrayList<ArrayList<String>> ans;

    public EightQueens(int n, ArrayList<ArrayList<String>> ans) {
        this.n = n;
        this.board = new boolean[n][n];
        this.colEmpty = new boolean[n];
        this.upDiagEmpty = new boolean[n * 2 - 1];
        this.downDiagEmpty = new boolean[n * 2 - 1];
        this.ans = ans;
        Arrays.fill(this.colEmpty, true);
        Arrays.fill(this.upDiagEmpty, true);
        Arrays.fill(this.downDiagEmpty, true);
    }

    static int numcalls = 0;

    public boolean findSolution(int row) {
        numcalls++;
        if (row == n) {
            printSolution();
            return true;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col)) {
                System.out.println(numcalls + " " + row + " " + col);
                placeQueen(row, col);
                findSolution(row + 1);
                removeQueen(row, col);
                System.out.println(numcalls + " " + row + " " + col);

            }
        }
        return false;
    }

    public boolean isSafe(int row, int col) {
        return colEmpty[col] && upDiagEmpty[row + col] && downDiagEmpty[n - 1 + row - col];
    }

    public void placeQueen(int row, int col) {
        if (isSafe(row, col)) {
            board[row][col] = true;
            colEmpty[col] = false;
            upDiagEmpty[row + col] = false;
            downDiagEmpty[n - 1 + row - col] = false;
        }
    }

    public void removeQueen(int row, int col) {
        board[row][col] = false;
        colEmpty[col] = true;
        upDiagEmpty[row + col] = true;
        downDiagEmpty[n - 1 + row - col] = true;
    }

    public void printSolution() {
        ArrayList<String> sol = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            String currLine = "";
            for (int j = 0; j < n; j++) {
                if (board[i][j]) {
                    currLine += "Q";
                } else {
                    currLine += ".";
                }
            }
            sol.add(currLine);
        }
        ans.add(sol);
    }
}

// https://codedrills.io/contests/interview-practice-round-26/problems/chess
// https://codedrills.io/submissions/332405