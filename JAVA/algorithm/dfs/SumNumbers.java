package JAVA.algorithm.dfs;

/*
129. 求根到叶子节点数字之和
给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

例如，从根到叶子节点路径 1->2->3 代表数字 123。

计算从根到叶子节点生成的所有数字之和。

说明: 叶子节点是指没有子节点的节点。
*/

public class SumNumbers {
    private int sum = 0;

    private void dfs(TreeNode root, int num) {
        if (root != null) {
            num = num * 10 + root.val;
            if (root.left == null && root.right == null) {
                sum += num;
            }
            dfs(root.left, num);
            dfs(root.right, num);
        }
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
}