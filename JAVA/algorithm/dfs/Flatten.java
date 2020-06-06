package JAVA.algorithm.dfs;

/*
114. 二叉树展开为链表
给定一个二叉树，原地将它展开为一个单链表。
*/

public class Flatten {
    public void flatten(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = null;
                TreeNode curr = root;
                while (curr.right != null) {
                    curr = curr.right;
                }
                curr.right = temp;
            }
            flatten(root.right);
        }
    }
}