package 数据结构与算法.你要掌握的题型.完全背包问题;

import jdk.nashorn.internal.ir.CallNode;

/**
 * @author xuzaiya
 * @2020/8/3 10:05
 * 文件说明:完全背包问题
 * 有n中提及和价值为wi和vi的物品，有一个容量为W的背包，求出背包能装下的最大价值，每种物品的数量是无限的
 * dp[][]数组的含义:dp[i][j]dp[i][j]=从编号为1−i1−i的物品中挑选物品放入容量为jj的背包中能得到的最大价值。注意：n种物品编号范围为1-n，0做作递推的起点。
 * 初始条件：dp[0][0−W]=0dp[0][0−W]=0
 *
 * 递推公式：dp[i][j]=max{dp[i−1][j−k∗w[i]]+k∗v[i]∣0≤k&k∗w[i]≤j}
 *结果在dp[n][w]中
 *
 */
public class Demo {
    public static void main(String[] args) {
        int N = 3;//几个物品
        int V = 5; //总容量
        int[] weigth = {0,3,2,2};
        int[] Value = {0,5,10,20};
        int[][] F =new int[N=1][V+1];

        for (int i = 0;i <= N;i++){
            F[i][0] = 0;
        }
        for (int v = 0;v <= V;v++){
            F[0][v] = 0;
        }
        //递推
        for(int i=1;i<=N;i++){
            for(int v=1;v<=V;v++){
                F[i][v] = 0;
                int nCount = v/weigth[i];
                for(int k=0;k<=nCount;k++){
                    //F[i][v] = Math.max(F[i][v],F[i-1][v-k*weigth[i]]+k*);
                }
            }
        }



    }
}
