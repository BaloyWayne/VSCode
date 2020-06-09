package JAVA.algorithm.dfs;

/*
116. 填充每个节点的下一个右侧节点指针
给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
*/

public class Connect {
    private void dfs(Node root) {
        if (root != null) {
            if (root.left != null) {
                root.left.next = root.right;
            }
            if (root.right != null && root.next != null) {
                root.right.next = root.next.left;
            }
            dfs(root.left);
            dfs(root.right);
        }
    }

    public Node connect(Node root) {
        dfs(root);
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};