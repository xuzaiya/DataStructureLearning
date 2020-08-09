package 旭仔专用测试Demo.贝壳;

import net.sf.json.util.JSONUtils;
import org.springframework.objenesis.SpringObjenesis;

import java.util.Scanner;

/**
 * @author xuzaiya
 * @2020/7/29 13:46
 * 文件说明:
 */
public class demo {

    public static void main(String[] args) {
        prob3();
    }

    public static  void prob3(){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        long m=in.nextLong();
        int p=0;
        long count=0l;
        while(p<n && m>0){
            int x=in.nextInt();
            int y=in.nextInt();
            while(m>0 && m>=y && x>0) {
                m-=y;
                count++;
                x--;
            }
            p++;
        }
        System.out.println(count);
    }

}
