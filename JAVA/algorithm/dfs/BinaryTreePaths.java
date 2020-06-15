package JAVA.algorithm.dfs;

/*
257. 二叉树的所有路径
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。
*/

import java.util.*;

public class BinaryTreePaths {
    private List<String> list = new ArrayList<>();
    private StringBuilder str = new StringBuilder();

    private void dfs(TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                str.append(root.val);
                list.add(str.toString());
                str.delete(str.length() - ("" + root.val).length(), str.length());
                return;
            }
            str.append(root.val+"->");
            dfs(root.left);
            dfs(root.right);
            str.delete(str.length() - ("" + root.val).length()-2, str.length());
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return list;
    }
}