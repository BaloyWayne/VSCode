package JAVA.algorithm.dfs;

//主函数

public class Main {
    public static void main(String[] args) {
        FindOrder f=new FindOrder();
        int[][] prerequisites=new int[][]{{1,0}};
        int[] temp=f.findOrder(2, prerequisites);
        for(int i=0;i<temp.length;i++){
            System.out.println(temp[i]);
        }
    }
}