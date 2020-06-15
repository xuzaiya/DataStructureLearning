package 数据结构与算法.java排序算法.java各种排序算法汇总.基数排序;

import java.util.Arrays;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/22 20:55
 * @Description: # 类的描述
 */
public class RadixSort2 {
    public static void main(String[] args) {
        int[]arr =new int[]{100,200,345,2,45,900,12,6,3,126};
        basic(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void basic(int[]arr){
        //按照上面的步骤，我们先找到需要比较多少次，也就是最大数是多少
        int maxNum = arr[0];
        //我们把第一个默认为最大数，依次从数组中找到比他大的，然后替换这个数字
        for(int i = 1; i < arr.length;i++){
            if(arr[i] > maxNum){
                maxNum = arr[i];
            }
        }


        //上面我们找到最大数之后，我们就知道比较多少次了，只需要计算这个最大数的长度
        //为了计算他的长度，我们可以把它变成一个字符串，这样子，我们可以直接计算他的长度
        int maxLength = (maxNum + "").length();

        for (int i=1;i<=maxLength;i++){
            //构建一个二维数组来装入每次
            int[][] temp = new int[10][arr.length];
            //构建一个数组用来记录每次数组中的键值存放的位置
            int[][] index = new int[10][1];


            //这个时候我们来想这么一个问题，怎么求一个数字的个位数字是多少呢？
            //我们用这个数字除以10，然后余下是不是就是个位数数字，是的
            //所以我们总结出这样的一个规律
            //比如一个数字为 125
            //求个位 ： 125 % 10 / 1 = 5
            //求十位 ： 125 % 100 / 10 = 2
            //求百位 ： 125 % 1000 / 100 = 1
            //为了验证这个，我特地在本类下面有写这个函数counts,可以自行验证

            int z = 1;
            for (int p =1;p<=i;p++){
                z = z*10;
            }

            for (int j=0;j<arr.length;j++){
                int Y = arr[j] % z / (z / 10);
                temp[Y][index[Y][0]] = arr[j];
                index[Y][0]++;
            }

            //经过第一轮个位之后，把数据重新放回到原先的数组中
            int p = 0;
            for(int k=0;k < 10;k++){
                for(int s = 0; s < index[k][0];s++){
                    arr[p] = temp[k][s];
                    p++;
                }
            }


        }



    }

}
