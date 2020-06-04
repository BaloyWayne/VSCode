package JAVA.algorithm.dfs;

/*
101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。
*/

public class IsSymmetric {
    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }
}