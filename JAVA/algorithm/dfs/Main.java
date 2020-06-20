package JAVA.algorithm.dfs;

//主函数
import java.util.*;
public class Main {
    public static void main(String[] args) {
        PacificAtlantic p=new PacificAtlantic();
        int[][] matrix={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        p.pacificAtlantic(matrix);
    }
}