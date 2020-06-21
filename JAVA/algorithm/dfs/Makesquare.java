package JAVA.algorithm.dfs;

/*
473. 火柴拼正方形
还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。

输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
*/

import java.util.Arrays;

public class Makesquare {
    private int[] sum = new int[4];
    private int target;
    private int[] nums;
    private int num;

    private boolean dfs(int index) {
        if (index < 0) {
            return sum[0] == target && sum[1] == target && sum[2] == target && sum[3] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (sum[i] + nums[index] > target) {
                continue;
            }
            sum[i] += nums[index];
            if (dfs(index - 1)) {
                return true;
            }
            sum[i] -= nums[index];
        }
        return false;
    }

    public boolean makesquare(int[] nums) {
        this.nums = nums;
        this.num = nums.length;
        if (num < 4) {
            return false;
        }
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }
        if (totalSum % 4 != 0) {
            return false;
        }
        target = totalSum / 4;
        Arrays.sort(nums);
        return dfs(num - 1);
    }
}