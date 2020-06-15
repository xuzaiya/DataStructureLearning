package 数据结构与算法.java链表.双端链表的实现.双向链表的实现;

public class Node {
    public int data;
    public Node next; //后继节点
    public Node pre;//前继节点

    public Node(int value,Node pre,Node next){
        this.data = value;
        this.pre= pre;
        this.next = next;
    }

    public Node(int data){
        this(data,null,null);
    }


}
