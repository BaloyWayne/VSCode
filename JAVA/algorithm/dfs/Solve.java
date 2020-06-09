package JAVA.algorithm.dfs;

/*
130. 被围绕的区域
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
*/

public class Solve {
    private int[][] neigh = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private char[][] board;
    private int rows;
    private int cols;

    private void dfs(int i, int j) {
        board[i][j] = 'B';
        for (int[] temp : neigh) {
            int temp_i = i + temp[0];
            int temp_j = j + temp[1];
            if (temp_i >= 0 && temp_i < rows && temp_j >= 0 && temp_j < cols && board[temp_i][temp_j] == 'O') {
                dfs(temp_i, temp_j);
            }
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(i, cols - 1);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(rows - 1, j);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}