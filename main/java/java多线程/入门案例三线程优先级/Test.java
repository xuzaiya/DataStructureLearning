package java多线程.入门案例三线程优先级;

public class Test {
    public static void main(String[] args) {
        Thread minPriority = new Thread(new MaxPriority(),"优先级较低的线程");
        Thread maxPriority = new Thread(new MinPriority(),"优先级较高的线程");
        minPriority.setPriority(Thread.MIN_PRIORITY);
        maxPriority.setPriority(Thread.MAX_PRIORITY);
        minPriority.start();
        maxPriority.start();
    }
}
