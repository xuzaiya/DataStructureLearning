package 刷题;

/**
 * @author xuzaiya
 * @2020/6/21 10:17
 * 文件说明: 反转字符串的升级版
 */
public class Demo2 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        reverseStr(s,k);
    }

    public static String reverseStr(String s, int k) {
        char[] strArray = s.toCharArray();
        char temp ;
        for(int i=0,len=strArray.length;i<len;i+=2*k){
            if(len-i<k){
                reserve(strArray,i,len-1);
            }else{
                reserve(strArray,i,i+k-1);
            }

        }
        return String.valueOf(strArray);

    }


    public static void reserve(char[] strArray,int i,int j){

        for(;i<j;i++,j--){
            char temp = strArray[i];
            strArray[i] = strArray[j];
            strArray[j] = temp;
        }

    }

}
