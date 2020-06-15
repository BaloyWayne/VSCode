package JAVA.algorithm.dfs;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer,String> map=new HashMap<>();
        map.put(1, "一");
        String str=map.get(2);
        System.out.println(str==null);
    }
}