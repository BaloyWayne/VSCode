package JAVA.algorithm.dfs;

/*
472. 连接词
给定一个不含重复单词的列表，编写一个程序，返回给定单词列表中所有的连接词。

连接词的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。
*/

import java.util.*;

public class FindAllConcatenatedWordsInADict {
    private List<String> list = new ArrayList<>();
    private TrieNode root = new TrieNode();

    private void buildTrieNode(String[] words) {
        for (String word : words) {
            if (!word.equals("")) {
                root.add(word);
            }
        }
    }

    private boolean dfs(String str, int start) {
        TrieNode node = root;
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!node.next.containsKey(c)) {
                return false;
            }
            node = node.next.get(c);
            if (node.isWord && dfs(str, i + 1)) {
                return true;
            }
        }
        return node.isWord && start != 0;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        buildTrieNode(words);
        for (String word : words) {
            if (dfs(word, 0)) {
                list.add(word);
            }
        }
        return list;
    }
}

class TrieNode {
    public boolean isWord;
    public HashMap<Character, TrieNode> next;

    public TrieNode() {
        isWord = false;
        next = new HashMap<>();
    }

    public void add(String str) {
        TrieNode node = this;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!node.next.containsKey(c)) {
                node.next.put(c, new TrieNode());
            }
            node = node.next.get(c);
        }
        node.isWord = true;
    }
}