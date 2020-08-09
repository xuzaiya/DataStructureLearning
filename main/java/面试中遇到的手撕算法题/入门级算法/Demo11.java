package 面试中遇到的手撕算法题.入门级算法;

/**
 * @author xuzaiya
 * @2020/7/2 9:55
 * 文件说明:判断字符串t是否是s的子串
 *
 */
public class Demo11 {
    public static void main(String[] args) {

    }
    public boolean isSubsequence(String s,String t){
        //判断子序列
        char[] str = s.toCharArray();
        int j = -1;
        for(int i=0;i<str.length;i++){
            j = t.indexOf(str[i],j+1);
            if(j == -1){
                return false;
            }
        }
        return true;

    }

}
