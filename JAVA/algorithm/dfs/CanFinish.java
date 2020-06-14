package JAVA.algorithm.dfs;

/*
207. 课程表
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]

给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
*/

import java.util.*;

public class CanFinish {
    private HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    private boolean[] light;
    private boolean[] trace;
    private boolean judge = true;

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
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.light = new boolean[numCourses];
        this.trace = new boolean[numCourses];
        buildMap(prerequisites);
        for (int i = 0; i < numCourses; i++) {
            if (!trace[i]) {
                dfs(i);
            }
        }
        return judge;
    }
}