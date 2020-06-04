package JAVA.algorithm;

/*
99. 恢复二叉搜索树
二叉搜索树中的两个节点被错误地交换。

请在不改变其结构的情况下，恢复这棵树。
*/

public class RecoverTree {
    private TreeNode prev;
    private TreeNode p, q;

    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            if (prev != null && prev.val >= root.val) {
                if (p == null) {
                    p = prev;
                }
                q = root;
            }
            prev = root;
            dfs(root.right);
        }
    }

    private void swap(TreeNode p, TreeNode q) {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }

    public void recoverTree(TreeNode root) {
        dfs(root);
        swap(p, q);
    }
}