package 数据结构与算法.java链表.单向链表;

public class testSingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList singleLinked =new SingleLinkedList();
        singleLinked.addHead("A");
        singleLinked.addHead("B");
        singleLinked.addHead("C");
        singleLinked.addHead("D");

        //打印当前链表信息
        singleLinked.display();

        //删除c
        singleLinked.delete("C");
        singleLinked.display();

        //查找
        System.out.println(singleLinked.find("B"));
    }
}
