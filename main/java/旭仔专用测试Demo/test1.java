package 旭仔专用测试Demo;

import java.util.Scanner;

/**
 * @ClassName test1
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/8/8 15:09
 * @Version 1.0
 */
public class test1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String rs=new String();
            String s=in.next();
            StringBuffer sb=new StringBuffer();
            StringBuffer sb1=new StringBuffer(s);
            for(int i=s.length()-1;i>=0;i--)
            {
                sb.append(s.charAt(i));
            }
            rs=sb.toString();

            for(int i=rs.length()-1;i>=1&&!isTrue(sb1.toString());i--){
                sb1.insert(rs.length(),rs.charAt(i));
            }
            System.out.println(sb1);    //输出得到的最短字符串
        }
        in.close();

    }

    public static boolean isTrue(String s) {
        boolean flag=true;
        for(int i=0;i<=s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                flag=false;
                break;
            }
        }
        return flag;
    }
}