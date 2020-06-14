package JAVA.algorithm.dfs;

/*
200. 岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。
*/

public class NumIslands {
    private char[][] grid;
    private boolean[][] light;
    private int rows;
    private int cols;
    private int[][] neigh = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private void dfs(int i, int j) {
        light[i][j] = true;
        for (int[] temp : neigh) {
            int temp_i = i + temp[0];
            int temp_j = j + temp[1];
            if (temp_i >= 0 && temp_i < rows && temp_j >= 0 && temp_j < cols && !light[temp_i][temp_j]
                    && grid[temp_i][temp_j] == '1') {
                dfs(temp_i, temp_j);
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.light = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!light[i][j] && grid[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }
}