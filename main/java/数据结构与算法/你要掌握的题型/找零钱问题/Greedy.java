package 数据结构与算法.你要掌握的题型.找零钱问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuzaiya
 * @2020/8/8 12:35
 * 文件说明:
 */
public class Greedy {
    static List<Integer> coins = new ArrayList<>();

    public static void main(String[] args) {
        coins.add(25);
        coins.add(20);
        coins.add(5);
        coins.add(1);
        System.out.println("硬币种类");
        System.out.println(Arrays.asList(coins));

        int target = 41;
        Result result = getLeastCoins(target);
        System.out.println("应找给对方的硬币 数量 ：" + result.datas.size());
        System.out.println(Arrays.asList(getLeastCoins(target).datas));

       // System.out.println(Arrays.asList(getLeastNumberCoins(target).datas));


    }

    private static Result getLeastCoins(int target){
        Result result = new Result();
        result.datas = new ArrayList<>();
        //已知coins是有序的
        for(Integer coin : coins){
            int count = target/coin;
            for(int i=0;i<count;i++){
                result.datas.add(coin);
            }
            //去余数
            target = target%coin;
        }
        return result;

    }

    //可以采用局部最优解法加排序算法，找到最优解
    /*private static Result getLeastNumberCoins(int target){
        Result minNumberResult = new Result();
        for(int i=0;i<coins.size();i++){
            Result current = getLeastCoinsByList(i,target);
            if (minNumberResult.datas != null) {
                if (minNumberResult.getCount() > current.getCount()) {
                    minNumberResult.datas = current.datas;
                }else{
                    //minNumb erResult.datas = current.datas;
                }
            }
        }
    }*/

    private static Result getLeastCoinsByList(int i,int target){
        Result result = new Result();
        result.datas = new ArrayList<>();
        //异质coins是有序的
        for (int j=i;j<coins.size();j++){
            int coin = coins.get(i);
            if(target>=coin){
                //求个数
                int count = target/coin;
                for (int m = 0;m<count;m++){
                    result.datas.add(coin);
                }
                //取余数
                target = target%coin;
            }
        }
        return result;
    }



    static class Result{
        public List<Integer> datas = null;
        public int getCount(){
            return datas.size();
        }
    }
}



