package Java多线程.java多线程与并发库高级应用.Demo22生产者和消费者模型;

/**
 * @author xuzaiya
 * @2020/7/5 17:02
 * 文件说明:消费者
 */
public class Customer {
    private Depot depot;
    public Customer(Depot depot){
        this.depot =depot;
    }
    //消费产品，新建一个线程从仓库中消费产品
    public void consumer(final int val){
        new Thread(){
            public void run(){
                depot.consume(val);
            }
        }.start();
    }
}
