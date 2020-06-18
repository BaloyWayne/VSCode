package JAVA.algorithm.stack;

/*
394. 字符串解码
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
*/

import java.util.*;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> num_stack = new Stack<>();
        Stack<String> str_stack = new Stack<>();
        int num = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                num_stack.push(num);
                str_stack.push(str.toString());
                num = 0;
                str.delete(0, str.length());
            } else if (c == ']') {
                int num_temp = num_stack.pop();
                StringBuilder str_temp = new StringBuilder();
                for (int j = 0; j < num_temp; j++) {
                    str_temp.append(str);
                }
                str.delete(0, str.length());
                str.append(str_stack.pop() + str_temp);
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }
}