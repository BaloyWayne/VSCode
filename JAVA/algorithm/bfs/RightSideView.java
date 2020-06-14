package JAVA.algorithm.bfs;

/*
199. 二叉树的右视图
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
*/

import java.util.*;

public class RightSideView {
    private List<Integer> list = new ArrayList<>();

    private void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.remove();
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            list.add(root.val);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        bfs(root);
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

    TreeNode(int x) {
        val = x;
    }
}