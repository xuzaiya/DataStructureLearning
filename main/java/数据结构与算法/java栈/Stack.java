package 数据结构与算法.java栈;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/24 15:37
 * @Description: # 类的描述
 */
public interface Stack<T> {
    /**
     * 栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * data元素入栈
     * @param data
     */
    void push(T data);

    /**
     * 返回栈顶元素,未出栈
     * @return
     */
    T peek();

    /**
     * 出栈,返回栈顶元素,同时从栈中移除该元素
     * @return
     */
    T pop();
}
