package 数据结构与算法.java链表.双端链表的实现.双向链表的实现;

public class DoubleByLinkedList {
    private Node first;
    private Node last;
    public DoubleByLinkedList(){
        first = null;
        last = null;
    }





    /*
    插入一个节点，在头结点插入一个节点

     */
    public void insertFirst(int value){
        Node node = new Node(value);
        if (isEmpty()){
            last = node;
        }else{
            first.pre = node;
        }
        node.next = first;
        first = node;
    }

    /*
    删除一个节点，在头部进行删除
     */
    public Node delteFirst(){
        Node temp = first;
        if (first.next == null){
            last =null;
        }else{
            first.next.pre = null;
        }
        first = temp.next;
        return temp;
    }

    /*
    删除一个节点，从尾部进行删除
    * */
    public Node deleteLast(){
        if (first.next == null){
            first = null;
        }else{
            last.pre.next = null;
        }
        last = last.pre;
        return last;
    }

    /*
    删除一个节点
     */
    public Node delete(int value){
        Node current = first;
        while(current.data !=value){
            if (current.next == null){
                return  null;
            }
            current = current.next;
        }
        if (current == first){
            first = first.next;
        }else{
            current.pre = current.next;
        }
        return  current;
    }

    /*
    查找等于某个值的节点
     */
    public Node find(int value){
        Node current = first;
        while(current.data !=value){
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
