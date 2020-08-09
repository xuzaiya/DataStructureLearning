package Java多线程.java多线程与并发库高级应用.Demo22生产者和消费者模型;

/**
 * @author xuzaiya
 * @2020/7/5 17:00
 * 文件说明:生产者
 *
 */
public class Producer {
    private Depot depot;
    public Producer (Depot depot){
        this.depot = depot;
    }

    //消费产品：新建一个线程向仓库中生产产品
    public void produce(final int val){
        new Thread(){
            public void run(){
                depot.produce(val);
            }
        }.start();
    }
}
