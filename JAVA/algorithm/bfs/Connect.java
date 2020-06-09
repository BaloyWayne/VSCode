package JAVA.algorithm.bfs;

/*
117. 填充每个节点的下一个右侧节点指针 II
给定一个二叉树

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。
*/

import java.util.*;

public class Connect {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = queue.remove();
            if (prev.left != null) {
                queue.add(prev.left);
            }
            if (prev.right != null) {
                queue.add(prev.right);
            }
            for (int i = 1; i < size; i++) {
                Node post = queue.remove();
                if (post.left != null) {
                    queue.add(post.left);
                }
                if (post.right != null) {
                    queue.add(post.right);
                }
                prev.next = post;
                prev = post;
            }
        }
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