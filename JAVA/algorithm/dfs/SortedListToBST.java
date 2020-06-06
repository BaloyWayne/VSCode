package JAVA.algorithm.dfs;

/*
109. 有序链表转换二叉搜索树
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
*/

public class SortedListToBST {
    private ListNode head;

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        root.left = left;
        root.right = sortedListToBST(mid + 1, end);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int len = getLen(head);
        return sortedListToBST(0, len - 1);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}