package 刷题;
/**
 * @author xuzaiya
 * @2020/6/21 9:22
 * 文件说明:求两个数的最大公约数
 */
public class Demo {
    public static void main(String[] args) {
        int num = getGreateCommonDivison(4,6);
        System.out.println(num);
    }

    //辗转相除法
    public static int getGreateCommonDivison(int a,int b){
        int big = a>b?a:b;
        int small=a<b?a:b;
        if(big%small ==0){
            return small;
        }
        return getGreateCommonDivison(big%small,small);
    }

    //更相减损法
    public static int getGreateCommonDivison3(int a,int b){
        if(a == b){
            return a;
        }
        int big = a>b?a:b;
        int small = a<b?a:b;
        return getGreateCommonDivison3(big-small,small);
    }

    //辗转相除法
    public static int get(int a,int b){
        int big = a>b?a:b;
        int small = a<b?a:b;
        if(big%small == 0){
            return small;
        }
        return get(big%small,small);
    }




}
