package 数据结构与算法.java栈和队列.队列.数组实现循环队列;

public class TEst {
    public static void main(String[] args) {
        Loopqueue<Integer> queue = new Loopqueue<Integer>(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(8);

        queue.remove();
        queue.insert(6);
        queue.insert(7);

    }
}
