package 数据结构与算法.java栈.链式栈的设计与实现;

import 数据结构与算法.java栈.Stack;
import 数据结构与算法.java队列.Node;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/24 15:42
 * @Description: # 类的描述
 */
public class LinkedStack<T> implements Stack<T>, Serializable {



    private static final long serialVersionUID = 1911829302658328353L;

    private Node<T> top;

    private int size;

    public LinkedStack(){
        this.top=new Node<T>();
    }

    public int size(){
        return size;
    }


    @Override
    public boolean isEmpty() {
        return top==null || top.data==null;
    }

    @Override
    public void push(T data) {
        if (data==null){
            throw new EmptyStackException();
        }
        if(this.top==null){//调用pop()后top可能为null
            this.top=new Node<>(data);
        }else if(this.top.data==null){
            this.top.data=data;
        }else {
            Node<T> p=new Node<>(data,this.top);
            top=p;//更新栈顶
        }
        size++;
    }

    @Override
    public T peek()  {
        if(isEmpty()){
            throw new EmptyStackException();
        }

        return top.data;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }

        T data=top.data;
        top=top.next;
        size--;
        return data;
    }


    public static void main(String[] args){
        LinkedStack<String> sl=new LinkedStack<>();
        sl.push("A");
        sl.push("B");
        sl.push("C");
        int length=sl.size();
        for (int i = 0; i < length; i++) {
            System.out.println("sl.pop->"+sl.pop());
        }
    }
}
