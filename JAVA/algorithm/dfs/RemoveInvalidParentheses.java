package JAVA.algorithm.dfs;

/*
301. 删除无效的括号
删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。

说明: 输入可能包含了除 ( 和 ) 以外的字符。
*/

import java.util.*;

public class RemoveInvalidParentheses {
    private Set<String> set = new HashSet<>();
    private StringBuilder str = new StringBuilder();

    private void dfs(String s, int index, int leftNum, int rightNum, int leftRem, int rightRem) {
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                set.add(str.toString());
            }
            return;
        }
        char c = s.charAt(index);
        if ((c == '(' && leftRem > 0) || (c == ')' && rightRem > 0)) {
            dfs(s, index + 1, leftNum, rightNum, leftRem - (c == '(' ? 1 : 0), rightRem - (c == ')' ? 1 : 0));
        }
        str.append(c);
        if (c != '(' && c != ')') {
            dfs(s, index + 1, leftNum, rightNum, leftRem, rightRem);
        } else if (c == '(') {
            dfs(s, index + 1, leftNum + 1, rightNum, leftRem, rightRem);
        } else if (leftNum > rightNum) {
            dfs(s, index + 1, leftNum, rightNum + 1, leftRem, rightRem);
        }
        str.deleteCharAt(str.length() - 1);
    }

    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right = (left == 0) ? right + 1 : right;
                left = (left > 0) ? left - 1 : left;
            }
        }
        dfs(s, 0, 0, 0, left, right);
        return new ArrayList<>(set);
    }
}