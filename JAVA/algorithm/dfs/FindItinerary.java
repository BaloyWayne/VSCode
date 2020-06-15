package JAVA.algorithm.dfs;

/*
332. 重新安排行程
给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。

说明:

如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
所有的机场都用三个大写字母表示（机场代码）。
假定所有机票至少存在一种合理的行程。
*/

import java.util.*;

public class FindItinerary {
    private HashMap<String, ArrayList<String>> map = new HashMap<>();
    private List<String> list = new LinkedList<>();

    private void initMap(List<List<String>> tickets) {
        for (List<String> temp : tickets) {
            ArrayList<String> mapList = map.getOrDefault(temp.get(0), new ArrayList<String>());
            mapList.add(temp.get(1));
            map.put(temp.get(0), mapList);
        }
        for (ArrayList<String> temp : map.values()) {
            Collections.sort(temp);
        }
    }

    private void dfs(String s) {
        ArrayList<String> temp = map.get(s);
        while (temp != null && temp.size() > 0) {
            String str = temp.remove(0);
            dfs(str);
        }
        list.add(0, s);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        initMap(tickets);
        dfs("JFK");
        return list;
    }
}