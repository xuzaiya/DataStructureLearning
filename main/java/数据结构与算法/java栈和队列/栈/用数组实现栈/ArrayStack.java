package 数据结构与算法.java栈和队列.栈.用数组实现栈;

import java.util.Arrays;

public class ArrayStack<E> {
    private int size;
    private int top;
    private E[] data;


    public ArrayStack(int capacity){
        if (size<=0){
            throw  new IllegalArgumentException("capacity can't number = 0");
        }else{
            data = (E[])new Object[capacity];
            size = capacity;
            top=-1;
        }

    }

    public ArrayStack(){
        data=(E[])new Object[10];
        size = 10;
        top=-1;
    }

    public void push(E e){
        isGrow(top+1);
        data[++top] = e;
    }

    public E peek(){
        E e = null;
        if (size >= 0){
            e = data[top];
        }else{
            throw  new IllegalArgumentException(" NO Elements are available");
        }
        return e;
    }

    public void pop(){
        if (size>=0){
            data[top] = null;
            top--;
        }else{
            throw new IllegalArgumentException("pop failed .no data");
        }

    }
    /*
    对数组实现动态的扩容，若数组容量不够，理论上直接将容量扩展一倍
     */
    private void isGrow(int minCapacity){
        int capacity = size;
        int newCapacity = 0;
        if (capacity<=minCapacity){
            if ((capacity<<1) >Integer.MAX_VALUE){
                newCapacity = Integer.MAX_VALUE;
            }else{
                newCapacity = (capacity<<1);
            }
            this.size = newCapacity;
            Arrays.copyOf(data,newCapacity);
        }
    }


}
