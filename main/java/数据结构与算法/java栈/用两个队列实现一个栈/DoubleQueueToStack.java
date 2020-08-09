package 数据结构与算法.java栈.用两个队列实现一个栈;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author xuzaiya
 * @2020/6/28 9:56
 * 文件说明:用两个队列来实现一个栈，完成栈的push和pop操作
 */
public class DoubleQueueToStack {

    //创建两个队列
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    //入队
    public  void push(Integer t){
        queue1.add(t);
    }

    // 出队
    public Integer pop() {
        if (queue1.size() <= 1) {
            return queue1.poll();
        } else {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
        }

        while (queue2.size() > 0) {
            queue1.add(queue2.poll());
        }

        return queue1.poll();

    }
}
