package 数据结构与算法.java队列;

import org.omg.CORBA.NO_IMPLEMENT;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/24 14:23
 * @Description: # 类的描述
 */
public class Node<T> {
    public Node<T> next;
    public T data;

    public Node(){
        this(null);
    }

    public Node(T data){
        this.data = data;
    }

    public Node(T data,Node<T>next){
        this.data = data;
        this.next = next;
    }


}

