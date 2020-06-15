package 数据结构与算法.java链表.单链表的各种骚操作;

public class SingleLinkedList2 {
    private int size;
    private Node head;

    public SingleLinkedList2(){
        size = 0;
        head = null;
    }

    private class Node{
        private int data;
        private Node next;

        public Node(int obj){
            this.data = obj;
        }
    }

    //向链表里面添加数据
    public int addHead(int obj){
        Node node = new Node(obj);
        if(size == 0){
            head = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
        return obj;
    }

    //在链表头部删除元素
    public boolean deleteHead(){
        if (size == 0){
            return false;
        }else{
            int obj = head.data;
            head = head.next;
            size--;
            return true;
        }
    }

    //查找指定元素，并返回节点
    public Node find(int obj){
        Node current = head;
        int tempSize = size;
        while(tempSize>0){
            if(current.data == obj){
                return current;
            }else{
                current = current.next;
                tempSize--;
            }
        }

        return null;
    }

    //删除指定元素
    public boolean delete(int value){
        if (size == 0){
            return false;
        }

        Node current = head;
        Node previous = head;
        while(current.data!=value){
            if (current.next == null){
                return false;
            }else{
                previous = current;
                current = current.next;
            }
        }
        if (current == head){
            head = head.next;
            size--;
        }else{
            previous.next = current.next;
            size--;
        }
        return true;

    }

    //判断链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //显示链表的节点
    public void display(){
        if (size>0){
            Node node = head;
            int tempSize = size;
            if (tempSize == 1){
                System.out.println("["+head.data+"]");
                return ;
            }else{
                while(tempSize>0){
                    if (node.equals(head)){
                        System.out.print("["+node.data+"->");
                    }else if(node.next == null){
                        System.out.print(node.data+"]");
                    }else{
                        System.out.print(node.data+"->");
                    }
                    node = node.next;
                    tempSize--;
                }
                System.out.println();

            }
        }else{
            System.out.println("[]");
        }
    }
}
