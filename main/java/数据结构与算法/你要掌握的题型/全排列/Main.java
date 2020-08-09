package 数据结构与算法.你要掌握的题型.全排列;

import java.util.Stack;

/**
 * @author xuzaiya
 * @2020/8/1 17:57
 * 文件说明:
 */
public class Main {
    public static void main(String[] args) {
        perm(new int[]{1,2,3},new Stack<>());
    }

    public static void perm(int[]array,Stack<Integer> stack){
        if(array.length<=0){
            System.out.println(stack);
        }else{
            for (int i=0;i<array.length;i++){
                //tempArray 是一个临时数组
                //1,2,3全排列，先取出1，那么这时的tempArray中就是2,3
                int[] tempArray = new int[array.length-1];
                System.arraycopy(array,0,tempArray,0,i);
                System.arraycopy(array,i+1,tempArray,i,array.length-i-1);
                stack.push(array[i]);
                perm(tempArray,stack);
                stack.pop();
            }
        }
    }
}
