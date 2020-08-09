package 面试中遇到的手撕算法题.入门级算法;

import 面试中遇到的手撕算法题.ListNode;

/**
 * @author xuzaiya
 * @2020/7/2 9:55
 * 文件说明:链表的倒数第K个节点
 */
public class Demo7 {
    public static void main(String[] args) {

    }
    public static int getKNode(ListNode head, int k){
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0;i<k;i++){
            fast = fast.next;
        }
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

}
