package JAVA.algorithm.dfs;

/*
110. 平衡二叉树
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
*/

public class IsBalanced {
    private boolean judge = true;

    private int dfs(TreeNode root) {
        if (root == null || !judge) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) > 1) {
            judge = false;
        }
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return judge;
    }
}