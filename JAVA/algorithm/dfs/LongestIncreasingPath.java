package JAVA.algorithm.dfs;

/*
329. 矩阵中的最长递增路径
给定一个整数矩阵，找出最长递增路径的长度。

对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
*/

public class LongestIncreasingPath {
    private int[][] neigh = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    private int[][] matrix;
    private boolean[][] light;
    private int rows;
    private int cols;

    private int dfs(int i, int j, int[][] cache) {
        light[i][j] = true;
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        for (int[] temp : neigh) {
            int x = i + temp[0];
            int y = j + temp[1];
            if (x >= 0 && x < rows && y >= 0 && y < cols && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfs(x, y, cache));
            }
        }
        return ++cache[i][j];
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.light = new boolean[rows][cols];
        int[][] cache = new int[rows][cols];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!light[i][j]) {
                    max = Math.max(max, dfs(i, j, cache));
                }
            }
        }
        return max;
    }
}