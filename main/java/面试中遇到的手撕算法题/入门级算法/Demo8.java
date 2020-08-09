package 面试中遇到的手撕算法题.入门级算法;

import 面试中遇到的手撕算法题.ListNode;

/**
 * @author xuzaiya
 * @2020/7/2 9:55
 * 文件说明:链表的反转
 *
 */
public class Demo8 {
    public static void main(String[] args) {

    }
    //链表的反转
    public static ListNode reserveLink(ListNode head){
        if (head == null )return head;
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next  = pre;
            pre = cur;
            cur= next;
        }
        return pre;
    }

}
