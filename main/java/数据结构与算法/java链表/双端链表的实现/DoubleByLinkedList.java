package 数据结构与算法.java链表.双端链表的实现;

/*
双端链表的实现

 */
public class DoubleByLinkedList {
    private  Node first; //头结点
    private Node last; // 尾节点
    public DoubleByLinkedList(){
        first = null;
        last = null;
    }

    //插入一个节点
    public void insertFirst(int value){
        Node node = new Node(value);
        if (isEmpty()){
            last = node;
        }
        node.next = first;
        first = node;

    }

    //在尾部插入一个节点
    public void insertLast(int value){
        Node node = new Node(value);
        if (isEmpty()){
            first = node;
        }else{
            last.next = node;
        }
        last= node;
    }

    /*
    删除一个节点，在头部进行删除
     */

    public Node deleteFirst() {
        Node temp = first;
        if (first.next == null){
            last = null;
        }
        first = temp.next;
        return first;
    }



    /*
    删除等于某个数的节点
     */
    public Node delte (int value){
        Node current = first;
        Node previous = first;
        while(current.data!=value){
            if (current.next == null){
                return null;
            }
            previous = current;
            current = current.next;
        }
        if (current == first){
            first = first.next;
        }else{
            previous.next = current.next;
        }
        return current;
    }

    /*
    查找方法
     */
    public Node find(int value){
        Node current = first;
        while (current.data !=value){
            if (current.next == null){
                return null;
            }
            current = current.next;
        }
        return current;

    }

    /*
        判断是否为空
         */
    public boolean isEmpty(){
        return first == last;
    }


}
