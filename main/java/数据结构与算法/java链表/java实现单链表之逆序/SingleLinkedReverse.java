package 数据结构与算法.java链表.java实现单链表之逆序;

import 面试中遇到的手撕算法题.ListNode;

public class SingleLinkedReverse {

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }


    public static void main(String[] args) {
        SingleLinkedReverse slr = new SingleLinkedReverse();
        Node head, tail;
        head = tail = slr.new Node(0);
        for(int i=1; i<10; i++){
            Node p = slr.new Node(i);
            tail.next = p;
            tail = p;
        }
        tail = head;
        while(tail != null){
            System.out.print(tail.data+" " );
            tail = tail.next;
        }

        head = reverse(head);

        System.out.println( );
        while(head != null){
            System.out.print(head.data+" " );
            head = head.next;
        }
    }


    private static Node reverse(Node head) {
        if(head == null)return head;
        Node cur = head;
        Node pre = null;
        while(cur!=null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

}
