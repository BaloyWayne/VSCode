package JAVA.algorithm.dfs;

/*
133. 克隆图
给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。

图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。

class Node {
    public int val;
    public List<Node> neighbors;
}
*/

import java.util.*;

public class CloneGraph {
    private HashMap<LinkNode, LinkNode> map = new HashMap<>();

    public LinkNode cloneGraph(LinkNode node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        LinkNode cloneNode = new LinkNode(node.val, new ArrayList<LinkNode>());
        map.put(node, cloneNode);
        for (LinkNode temp : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(temp));
        }
        return cloneNode;
    }
}

class LinkNode {
    public int val;
    public List<LinkNode> neighbors;

    public LinkNode() {
        val = 0;
        neighbors = new ArrayList<LinkNode>();
    }

    public LinkNode(int _val) {
        val = _val;
        neighbors = new ArrayList<LinkNode>();
    }

    public LinkNode(int _val, ArrayList<LinkNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}