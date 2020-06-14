package JAVA.algorithm.dfs;

/*
210. 课程表 II
现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。

可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
*/

import java.util.*;

public class FindOrder {
    private HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    private Stack<Integer> stack = new Stack<>();
    private boolean[] light;
    private boolean[] trace;
    private boolean judge=true;

    private void buildMap(int[][] prerequisites) {
        for (int[] temp : prerequisites) {
            ArrayList<Integer> list = map.getOrDefault(temp[1], new ArrayList<>());
            list.add(temp[0]);
            map.put(temp[1], list);
        }
    }

    private void dfs(int i) {
        trace[i] = true;
        if (!judge) {
            return;
        }
        light[i] = true;
        if (map.containsKey(i)) {
            ArrayList<Integer> list = map.get(i);
            for (int temp : list) {
                if (light[temp]) {
                    judge = false;
                    return;
                }
                if (!trace[temp]) {
                    dfs(temp);
                }
            }
        }
        light[i] = false;
        stack.push(i);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.light = new boolean[numCourses];
        this.trace = new boolean[numCourses];
        buildMap(prerequisites);
        for (int i = 0; i < numCourses; i++) {
            if (!trace[i]) {
                dfs(i);
            }
        }
        if (!judge) {
            return new int[] {};
        }
        int[] temp = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            temp[i] = stack.pop();
        }
        return temp;
    }
}