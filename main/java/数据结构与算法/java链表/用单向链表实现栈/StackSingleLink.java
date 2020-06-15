package 数据结构与算法.java链表.用单向链表实现栈;

import 数据结构与算法.java链表.单向链表.SingleLinkedList;

public class StackSingleLink {
    private SingleLinkedList link;

    public StackSingleLink(){
        link = new SingleLinkedList();
    }

    //添加元素
    public void push(Object obj){
        link.addHead(obj);
    }

    //移出栈顶元素
    public Object pop(){
        Object obj = link.deleteHead();
        return obj;
    }

    // 判断栈是否为空
    public boolean isEmpty(){
        return link.isEmpty();
    }

    //打印栈内元素的信息
    public void display(){
        link.display();
    }
}
