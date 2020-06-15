package 刷题.链表;

public class Test237 {
    public static void main(String[] args) {

    }

    public ListNode deleteNode(ListNode head,int val){
        //如果头结点的val就是要找的val
        while(head!=null && head.val == val){
            head = head.next;
        }

        if (head == null){
            return head;
        }
        //删除head.next 位置
        ListNode pre = head;
        while(pre.next!=null){
            if (pre.next.val == val){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }
        return head;

    }
}


