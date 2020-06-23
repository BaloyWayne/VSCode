package JAVA.algorithm.dfs;

/*
488. 祖玛游戏
回忆一下祖玛游戏。现在桌上有一串球，颜色有红色(R)，黄色(Y)，蓝色(B)，绿色(G)，还有白色(W)。 现在你手里也有几个球。

每一次，你可以从手里的球选一个，然后把这个球插入到一串球中的某个位置上（包括最左端，最右端）。接着，如果有出现三个或者三个以上颜色相同的球相连的话，就把它们移除掉。重复这一步骤直到桌上所有的球都被移除。

找到插入并可以移除掉桌上所有球所需的最少的球数。如果不能移除桌上所有的球，输出 -1 。
*/

import java.util.*;

public class FindMinStep {
    private int num = Integer.MAX_VALUE;
    private HashMap<Character, Integer> map = new HashMap<>();
    private char[] colors = { 'R', 'Y', 'B', 'G', 'W' };

    private void initMap(String hand) {
        for (int i = 0; i < hand.length(); i++) {
            char c = hand.charAt(i);
            map.compute(c, (k, v) -> v = v == null ? 1 : v + 1);
        }
    }

    private StringBuilder eliminate(StringBuilder board) {
        boolean judge = true;
        while (judge) {
            judge = false;
            int i = 0;
            while (i < board.length()) {
                int j = i + 1;
                while (j < board.length() && board.charAt(i) == board.charAt(j)) {
                    j++;
                }
                if (j - i >= 3) {
                    board.delete(i, j);
                    judge = true;
                }
                i = j;
            }
        }
        return board;
    }

    private void dfs(StringBuilder board, int step) {
        if (step >= num) {
            return;
        }
        if (board.length() == 0) {
            num = Math.min(num, step);
        }
        for (int i = 0; i < board.length(); i++) {
            char c = board.charAt(i);
            int j = i + 1;
            while (j < board.length() && board.charAt(j) == c) {
                j++;
            }
            if (j - i == 1 && map.getOrDefault(c, 0) >= 2) {
                StringBuilder temp = new StringBuilder(board);
                temp.insert(i, c + "" + c);
                map.compute(c, (k, v) -> v = v - 2);
                dfs(eliminate(temp), step + 2);
                map.compute(c, (k, v) -> v = v + 2);
            } else if (j - i == 2) {
                if (map.getOrDefault(c, 0) >= 1) {
                    StringBuilder temp = new StringBuilder(board);
                    temp.insert(i, c);
                    map.compute(c, (k, v) -> v - 1);
                    dfs(eliminate(temp), step + 1);
                    map.compute(c, (k, v) -> v + 1);
                }
                for (char color : colors) {
                    if (color == c) {
                        continue;
                    }
                    if (map.getOrDefault(color, 0) >= 1) {
                        StringBuilder temp = new StringBuilder(board);
                        temp.insert(i + 1, color);
                        map.compute(color, (k, v) -> v - 1);
                        dfs(eliminate(temp), step + 1);
                        map.compute(color, (k, v) -> v + 1);
                    }
                }
            }
        }
    }

    public int findMinStep(String board, String hand) {
        initMap(hand);
        dfs(new StringBuilder(board), 0);
        return num == Integer.MAX_VALUE ? -1 : num;
    }
}