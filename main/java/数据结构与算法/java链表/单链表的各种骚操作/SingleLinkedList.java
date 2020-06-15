package 数据结构与算法.java链表.单链表的各种骚操作;


import 刷题.链表.ListNode;

import java.util.Stack;

public class SingleLinkedList {
    private int size ;// 节点的个数
    private Node head; //头结点

    public SingleLinkedList(){
        size = 0;
        head = null;
    }

    //链表的每个节点类
    private class Node{
        private int data; //每个节点的数据
        private Node next; //每个节点指向下一个节点的连接

        public Node(int obj){
            this.data = obj;
        }
    }

    // 在链表的表头添加元素
    public Object addHead(int obj){
        Node newHead = new Node(obj);
        if (size == 0){
            head = newHead;
        }else{
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;
    }



    // 在链表头删除元素
    public Object delteHead(){
        Object obj = head.data;
        head  = head.next;
        size--;
        return obj;
    }

    //查找指定元素,找到了返回节点NOde，找不到返回null
    public Node find(Object obj){
        Node current = head;
        int tempSize = size;
        while(tempSize>0){
            if (obj.equals(current.data)){
                return current;
            }else{
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

    //删除指定的元素，删除成功后返回true
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
        return size == 0;
    }

    //显示节点信息
    public void display(){
        if (size>0){
            Node node = head;
            int tempSize = size;
            if (tempSize == 1){
                System.out.println("["+node.data+"]");
                return ;
            }

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
        }else{
            System.out.println("[]");
        }
    }

    // 链表反转 - 遍历法-
    public void reverse(){
        //上一个节点
        Node previousNode = null;
        //当前节点
        Node currentNode = head;
        //头结点
        Node headNode = null;
        while(currentNode !=null){
            //将当前的下一个节点保存起来
            Node nextNode = currentNode.next;
            //判断当前节点是否为尾节点
            if (nextNode == null){
                headNode = currentNode;
            }
            //将当前节点指向上一个节点，反转
            currentNode.next = previousNode;
            //上一个节点保存当前节点的信息，即上一个节点指向当前节点的下一个节点
            previousNode = currentNode;
            //当前节点变为当前节点的下一个节点
            currentNode = nextNode;
        }
        head = headNode;
    }

    //链表反转- 递归 - @Chase
    static Node reverseLinkedList(Node node) {
        //判断尾节点和空链表
        if (node == null || node.next == null) {
            return node;
        } else {
            //递归
            Node headNode = reverseLinkedList(node.next);
            node.next.next = node;
            node.next = null;
            return headNode;
        }
    }

    public void reverse2() {
        head =  reverseLinkedList(head);
    }

    //遍历求个数 - @Chase
    public int findall(){
        Node current = head;
        int tempSize = size;
        int sum = 1;
        while(current!=null){
            System.out.println(sum);
            sum+=1;
            current = current.next;
        }
        return sum;
    }

    //找出链表的中间节点
    public Node findMiddelNode(Node head){
        if (head == null){
            return head;
        }
        Node slow = head,fast= head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }


    //找出链表的中间节点
    public Node findMiddelNode2(Node node){
        if (head == null){
            return head;
        }
        Node slow = head,fast = head;
        if (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }




    // 用快慢指针判断链表是否有环
    public boolean isCircleLinkedListNode(Node head){
        if (head == null){
            return false;
        }

        Node slow=head,fast = head;
        while (fast.next!=null&&fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }



    //用快慢指针判断链表是否有环
    public boolean isCircleLinkedListNode2(Node head){
        if (head == null){
            return false;
        }

        Node slow = head,fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    //将某个元素插入到排序链表中
    public Node insertNode(Node head,int target){
        Node targetNode = new Node(target);
        Node current = head;
        if (current == null || current.data >= target){
            targetNode.next = head;
            return targetNode;
        }
        while(current!=null){
            if (current.next == null || target>current.next.data){
                targetNode.next = current.next;
                current.next = targetNode;
            }
            current = current.next;
        }
        return head;
    }



    //将某个元素插入到已经排序的链表中
    public Node insertNode2(Node head,int target){
        Node targetNode = new Node(target);
        Node current = head;
        if (current == null || current.data>=target){
            targetNode.next = head;
            return targetNode;
        }

        while(current!=null){
            if (current.next == null || target<current.next.data){
                targetNode.next = current.next;
                current.next = targetNode;
            }
            current = current.next;
        }
        return head;

    }

    //删除倒数第k个节点
    /* public Node deleteLastKNode(Node node,int k){
        Node fast = node;
        int i=1;
        while(fast!=null && i<k){
            fast= fast.next;
            ++i;
        }
    } */


    //合并两个有序链表
    public Node mergeTwoLists(Node la,Node lb){
        if (la == null)return lb;
        if(lb == null) return la;
        Node head = null;
        if (la.data<lb.data){
            head = la;
            head.next = mergeTwoLists(la.next,lb);
        }else{
            head = lb;
            head.next = mergeTwoLists(la,lb.next);
        }
        return head;
    }


    //合并两个有序链表
    public Node mergeTwoList(Node la,Node lb){
        if (la == null)return lb;
        if (lb==null )return la;
        Node head= null;
        if (la.data<lb.data){
            head = la;
            head.next =mergeTwoList(la.next,lb);
        }else{
            head = lb;
            head.next = mergeTwoList(la,lb.next);
        }
        return head;
    }


    // 找到两个单链表相交的起始点
    public int calculateNodes(Node node){


        return 0;
    }

    //判断一个链表是不是回文链表
    public boolean isPalindrome(Node node){
        Node fast =node;
        Node slow = node;
        Stack<Integer> stack = new Stack<>();
        /*
        将链表的前半部分元素装入栈中，当快速runner
        到底链表尾时，则慢速runner已经处于链表的中间位置
          */
        while(fast!=null && fast.next!=null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        //当链表为奇数个数时，跳过中间元素
        if (fast!=null){
            slow = slow.next;
        }
        while(slow!=null){
            //如果两个不相同，则该链表不是回文数
            if (stack.pop()!=slow.data){
                return false;
            }else{
                slow = slow.next;
            }
        }
        return true;
    }



    //奇偶链表
    /*
    给定一个单链表，把所有的奇数节点和偶数节点分别排在一起，这里的奇数节点和偶数节点是节点编号的奇偶性
      */
    public Node oddEvenList(Node head){
        if (head == null){
            return null;
        }
        Node oddList = head;
        Node evenList = head;
        Node evenHead = evenList;
        while(evenList!=null&&evenList.next!=null){
            oddList.next = evenList.next;
            oddList = oddList.next;
            evenList.next = oddList.next;
            evenList=evenList.next;
        }
        oddList.next = evenHead;
        return head;
    }





}
