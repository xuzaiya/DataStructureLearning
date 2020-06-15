package 数据结构与算法.java栈和队列.队列.数组实现循环队列;

import java.util.Arrays;

public class Loopqueue<E> {
    private int maxsize;
    private int front; //对头指针
    private int rear; //队尾指针
    private E[] data;
    private int nItems;

    //循环队列必须定制队列的长度
    public Loopqueue(int maxsize){
        if (maxsize<=0){
            throw  new IllegalArgumentException("maxsize can't number=0 ");
        }else{
            this.maxsize= maxsize;
            data=(E[])new Object[maxsize];
            front = 0 ;
            rear = -1;
            nItems = 0;
        }
    }

    //插入元素
    public void insert(E e){
        if (!isFull()){
            if (rear == maxsize-1){
                rear = -1;
            }
            data[++rear] = e;
            nItems++;
        }
    }

    //删除元素
    public void remove(){
        if (nItems<=0){
            throw  new IllegalArgumentException("NO elements are available ");
        }else{
            data[front] = null;
            front++;
        }
        if (front == maxsize){
            front = 0;
        }
        nItems--;
    }

    //判断队列是否满了
    public boolean isFull(){
        return maxsize == nItems;
    }

    @Override
    public String toString() {
        return "Loopqueue{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
