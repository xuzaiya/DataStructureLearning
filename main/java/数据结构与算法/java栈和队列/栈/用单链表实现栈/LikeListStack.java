package 数据结构与算法.java栈和队列.栈.用单链表实现栈;

import 数据结构与算法.java链表.双端链表的实现.DoubleByLinkedList;

public class LikeListStack {
    private DoubleByLinkedList stack;
    public LikeListStack(){
        stack = new DoubleByLinkedList();
    }
    public void  push(int e){
        stack.insertFirst(e);

    }
    public void pop(){
        stack.deleteFirst();
    }

}
