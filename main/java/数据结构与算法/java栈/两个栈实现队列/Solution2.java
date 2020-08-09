package 数据结构与算法.java栈.两个栈实现队列;


import java.util.Stack;

/**
 * @author xuzaiya
 * @2020/7/3 7:59
 * 文件说明:
 */
public class Solution2 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int key){
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack2.push(key);
    }

    public void pop(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack2.pop();
    }
}
