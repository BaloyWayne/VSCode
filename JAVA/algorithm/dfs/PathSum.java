package JAVA.algorithm.dfs;

/*
113. 路径总和 II
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。
*/

import java.util.*;

public class PathSum {
    private List<List<Integer>> list = new ArrayList<>();

    @SuppressWarnings("unchecked")
    private void dfs(TreeNode root, int sum, ArrayList<Integer> temp) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                if (root.val == sum) {
                    temp.add(root.val);
                    list.add((ArrayList<Integer>) temp.clone());
                    temp.remove(temp.size() - 1);
                }
                return;
            }
            temp.add(root.val);
            dfs(root.left, sum - root.val, temp);
            dfs(root.right, sum - root.val, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<>());
        return list;
    }
}