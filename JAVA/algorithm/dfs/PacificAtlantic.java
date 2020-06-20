package JAVA.algorithm.dfs;

/*
417. 太平洋大西洋水流问题
给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。

规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。

请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
*/

import java.util.*;

public class PacificAtlantic {
    private List<List<Integer>> list = new ArrayList<>();
    private int[][] neigh = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    private int[][] matrix;
    private int rows;
    private int cols;

    private boolean inArea(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    private void dfs(int i, int j, boolean[][] sea) {
        sea[i][j] = true;
        for (int[] temp : neigh) {
            int x = i + temp[0];
            int y = j + temp[1];
            if (inArea(x, y) && !sea[x][y] && matrix[x][y] >= matrix[i][j]) {
                dfs(x, y, sea);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        boolean[][] pa = new boolean[rows][cols];
        boolean[][] at = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, pa);
            dfs(i, cols - 1, at);
        }
        for (int j = 0; j < cols; j++) {
            dfs(0, j, pa);
            dfs(rows - 1, j, at);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pa[i][j] && at[i][j]) {
                    list.add(Arrays.asList(i, j));
                }
            }
        }
        return list;
    }
}