package 数据结构与算法.你要掌握的题型.背包问题;

/**
 * @author xuzaiya
 * @2020/8/3 8:41
 * 文件说明:
 */
public class knapSack01 {
    public static void main(String[] args) {
        int[] w = {2,1,3,2};
        int[] v = {12,10,20,15};
        System.out.println(knapSack(w,v,5));
    }

    public static int knapSack(int[]w,int[] v,int C){
        int size = w.length;
        if (size == 0){
            return 0;
        }
        int[][]dp = new int[size][C+1];
        //初始化第一行
        //仅考虑容量为C的背包放0个物品的情况
        for(int i=0;i<=C;i++){
            dp[0][i] = w[0] <=i? v[0]:0;
        }

        //填充其他的行和列
        //dp[i][j] 放i间物品，容量为j的最大价值
        for(int i=1;i<size;i++){
            for (int j=0;j<=C;j++){
                dp[i][j] = dp[i-1][j];
                if(w[i] <=j){
                    dp[i][j] = Math.max(dp[i][j],v[i]+dp[i-1][j-w[i]]);
                }

            }
        }
        return dp[size-1][C];
    }
}
