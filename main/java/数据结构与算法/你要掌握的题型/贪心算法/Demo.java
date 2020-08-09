package 数据结构与算法.你要掌握的题型.贪心算法;

/**
 * @author xuzaiya
 * @2020/8/3 17:17
 * 文件说明: 找零钱问题
 */
public class Demo {
    public static void main(String[] args) {
        int[] m = {25,10,5,1};
        int target = 99;
        int[] result = giveMoney(m,target);
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]+"枚"+m[i]+"面值");
        }
    }

    public static  int[] giveMoney(int[]m,int target){
        int k = m.length;
        int [] num = new int[k];
        for(int i=0;i<k;i++){
            num[i] = target/m[i];
            target = target%m[i];
        }
        return num;
    }
}
