package 旭仔专用测试Demo.贝壳;

import java.util.Scanner;

/**
 * @author xuzaiya
 * @2020/7/29 13:48
 * 文件说明:
 */
public class Demo2 {

        public static void main(String[] args) {
            Scanner input=new Scanner(System.in);
            int n=input.nextInt();
            long m=input.nextInt();
            int[] p=new int[n];
            int[] w=new int[n];
            for(int i=0;i<n;i++){
                p[i]=input.nextInt();//存储个数
                w[i]=input.nextInt();//存储数量
            }
            long sum=m;
            int count=0;
            for(int i=0;i<n;i++){
                if(sum>0) {
                    for (int j = p[i]; j > 0; j--) {//从最大价值的最大数量开始减
                        if (j * w[i] > sum) {
                            continue;
                        } else {
                            count += j;
                            sum -= j * w[i];
                            break;
                        }
                    }
                }
                else{
                    System.out.println(count);
                    return;
                }
            }
            System.out.println(count);
        }

}
