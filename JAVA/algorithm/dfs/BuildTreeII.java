package JAVA.algorithm.dfs;

/*
106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。
*/

public class BuildTreeII {
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                root.left = buildTree(inorder, inStart, i - 1, postorder, postStart, postStart + i - inStart - 1);
                root.right = buildTree(inorder, i + 1, inEnd, postorder, postStart + i - inStart, postEnd - 1);
            }
        }
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
}