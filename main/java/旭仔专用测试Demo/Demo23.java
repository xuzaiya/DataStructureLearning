package 旭仔专用测试Demo;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

/**
 * @author xuzaiya
 * @2020/8/8 15:41
 * 文件说明:
 */
public class Demo23 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str=scan.nextLine();
        String reverse = reverse(str);
        String newStr = "";

        newStr = str+reverse.substring(1);


        for (int i=str.length();i<=newStr.length();i++){
            if(str.length() == 2){
                System.out.println(str.substring(0,i)+str.charAt(0));
                return;
            }
            String s = newStr.substring(0,i);
            if(isPalindrome(s)){
                System.out.println(s);
                return ;
            }
        }
    }

    //判断是不是回文字符串
    public static boolean isPalindrome(String str) {
        int length=str.length();
        for(int i=0;i<length/2;i++) {
            if(str.toCharArray()[i]!=str.toCharArray()[length-i-1]) {
                return false;
            }
        }
        return true;
    }
    //翻转字符串
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }




}
