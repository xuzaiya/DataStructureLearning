package 刷题.链表;

public class Test707 {

    class Node{
        int data;
        Node next;
        public Node(int obj){
            this.data = obj;
        }
    }

    int size;
    Node head;

    /*   Initialize your data structure here.  */
    public Test707() {
        size = 0;
        head = null;
    }

    /*   Get the value of the index-th node in the linked list. If the index is invalid, return -1.  */
    public int get(int index) {
        Node current = head;
        if(index<0 || index>=size){
            return -1;
        }else{
            int tempSize = 0;
            while(tempSize!=index){
                current = current.next;
                tempSize++;
            }
            return current.data;


        }

    }

    /*   Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.  */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(size == 0){
            head = newNode;
        }else{
            newNode.next= head;
            head = newNode;
        }
        size++;


    }

    /*   Append a node of value val to the last element of the linked list.  */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = newNode;
        size++;


    }

    /*   Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.  */
    public void addAtIndex(int index, int val) {
        if(index>size){
            return ;
        }
        if(index == size){
            addAtTail(val);
            return ;
        }
        if(index<=0){
            addAtHead(val);
            return ;
        }
        Node newHead = new Node(val);
        int tempSize = 0;
        Node current = head;
        Node previous = head;
        while(tempSize!=index){
            previous = current;
            current= current.next;
            tempSize++;
        }
        previous.next = newHead;
        newHead.next = current;
        size++;


    }

    /*  Delete the index-th node in the linked list, if the index is valid.  */
    public void deleteAtIndex(int index) {
        if(index<0||index>=size)
        {
            return;
        }

        Node current = head;
        Node previous = head;
        int tempSize = 0;
        while(tempSize != index){
            previous = current;
            current = current.next;
            tempSize++;
        }

        if(current == head){
            head = head.next;
        }else if(current.next == null){
            previous.next = null;
        }else{
            previous.next = current.next;
        }


        size--;
    }


    public static void main(String[] args) {
        Test707 test = new Test707();
        test.addAtHead(3);
        test.addAtHead(42);
        test.addAtHead(43);
        test.addAtHead(44);
        test.addAtHead(45);
        test.addAtTail(20);
        //test.addAtIndex(6,21);
        System.out.println(test.get(2));
        test.deleteAtIndex(5);
        System.out.println(test.get(4));

    }

}
