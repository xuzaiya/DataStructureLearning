package 旭仔专用测试Demo;

import java.util.*;

/**
 * @Auther: xuzaiya
 * @Date: 2020/6/1 09:08
 * @Description: # 类的描述
 */
public class Demo6 {
    public static void main(String[] args)  {
        int num = maxNumberOfBalloons("balloon");
        System.out.println(num);


    }

    public static int maxNumberOfBalloons(String text) {
        String str = "balon";
        int min = Integer.MAX_VALUE;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int curmin = 0;
            int j=0;
            boolean temp = true;
            while(temp){
                j = text.indexOf(ch,j);
                if(j == -1){
                    temp = false;
                }else{
                    curmin++;
                    j++;
                }
            }
            if(curmin==0){
                return 0;
            }else{
                min = Math.min(min,curmin);
            }
        }
        return min;

    }

}
