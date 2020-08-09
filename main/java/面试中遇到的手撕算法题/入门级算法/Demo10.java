package 面试中遇到的手撕算法题.入门级算法;

import java.util.Stack;

/**
 * @author xuzaiya
 * @2020/7/2 9:55
 * 文件说明:双栈模拟队列
 *
 */
public class Demo10 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int node){
        //向stack2，push时，先判断stack2是否为空
        //如果不为则将stack2出栈，放进stack1中
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());

        }
        //stack2为空，则直接放入元素
        stack2.push(node);
    }


    public int pop(){
        //stack2元素出栈的时先判断stack1是否为空
        //如果不为空，则将stack1的元素出栈，放进stack2中
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        //stack1为空，此时stack2直接出栈
        return stack2.pop();
    }

}
