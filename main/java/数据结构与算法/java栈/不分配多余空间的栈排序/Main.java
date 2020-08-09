package 数据结构与算法.java栈.不分配多余空间的栈排序;


import java.util.Stack;

/**
 * @author xuzaiya
 * @2020/6/28 8:59
 * 文件说明:只分配一个栈的空间，栈排序
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(23);
        s.push(32);
        s.push(13);
        s.push(34);
        s.push(53);
        s.push(36);
        s.push(33);
        s = sort(s);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }

    }

    public static Stack<Integer> sort(Stack<Integer>s){
        Stack<Integer> ret = new Stack<Integer>();
        while(!s.isEmpty()){
            int top = s.pop();
            while(!ret.isEmpty() && ret.peek() < top){
                s.push(ret.pop());
            }
            ret.push(top);
        }
        return ret;
    }
}
