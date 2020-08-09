package 旭仔专用测试Demo;

import java.util.Scanner;
import java.util.Arrays;
public class BestFuWu{
 static public double greedy(int[] x,int s){
  int n=x.length;
  Arrays.sort(x);
  //System.out.println(Arrays.toString(x));
  int st[]=new int[n];
  int su[]=new int[n];
  int i=1,j=1;
  while(i< n){
   st[j]+=x[i];
   su[j]+=st[j];
   i++;
   j++;
   if(j>s){
    j=(s!=1)?j%s:1;//循环分配顾客到每一个服务点上
   }
  }
  double t=0;
  for(i=1;i<=s;i++){
  System.out.println("第"+i+"个服务点队列上所有顾客的等待时间su["+i+"]="+su[i]);
  t+=su[i];
  }
  t/=(n-1);
 return t;
}
public static void main(String[] args){
Scanner in=new Scanner(System.in);
 int n;//等待服务的顾客人数
 int s;//服务点的个数
 double t;//平均服务时间
System.out.println("请输入等待服务的顾客人数：");
 n=in.nextInt();
int[] x=new int[n+1];
System.out.println("请输入服务点个数：");
s=in.nextInt();

 System.out.println("请输入每个顾客需要服务的时间：");
for(int i=1;i<=n;i++){
// System.out.println("No."+i);
x[i]=in.nextInt();

        }
     t=greedy(x, s);
    System.out.println("平均等待时间最小值="+t);
    }
}
