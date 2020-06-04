package JAVA.algorithm;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        IsValidBST is = new IsValidBST();
        System.out.println(is.isValidBST(root));
    }
}