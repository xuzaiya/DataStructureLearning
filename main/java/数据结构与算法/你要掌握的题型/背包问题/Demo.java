package 数据结构与算法.你要掌握的题型.背包问题;

/**
 * @author xuzaiya
 * @2020/8/3 7:49
 * 文件说明:递归
 *
 * 0-1背包问题：
 * 给定n个重量为w1，w2,w3,w4,,,,wn,价值为v1,v2,v3,v4,,,,vn的物品和容量为C的背包，求最大价值
 *不放第n个物品：此时最大价值为：F(n-1,C)
 * 放置第n个物品，此时最大价值为：vn+F(n-1,C-wn)
 */
public class Demo {
    public static void main(String[] args) {
        int[] w = {2,1,3,2};//重量
        int[] v = {12,10,20,15};//价值
        System.out.println(knapSack(w,v,5));
    }




    public static int knapSack(int[] w,int[]v,int C){
        int size = w.length;
        return solveKS(w,v,size-1,C);
    }

    private static int solveKS(int[]w,int[]v,int index,int capacity){
        //基准条件，如果索引无效或容量不足，直接返回当前价值0
        if(index<0 || capacity <=0){
            return 0;
        }
        //不放第index个物品所得价值
        int res = solveKS(w,v,index-1,capacity);
        //放第index个物品所得的价值（前提是：第index个物品可以放的虾）
        if(w[index]<=capacity){
            res = Math.max(res,v[index]+solveKS(w,v,index-1,capacity-w[index]));
        }
        return res;

    }

}
