package JAVA.algorithm.dfs;

/*
124. 二叉树中的最大路径和
给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
*/

public class MaxPathSum {
    private int max = Integer.MIN_VALUE;

    private int dfs(TreeNode root) {
        if (root != null) {
            int leftNum = dfs(root.left);
            int rightNum = dfs(root.right);
            int left = leftNum > 0 ? leftNum : 0;
            int right = rightNum > 0 ? rightNum : 0;
            max = Math.max(max, root.val + left + right);
            return root.val + Math.max(left, right);
        }
        return 0;
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
}