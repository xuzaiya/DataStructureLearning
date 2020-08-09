package Java多线程.java多线程与并发库高级应用.Demo22生产者和消费者模型;

/**
 * @author xuzaiya
 * @2020/7/5 17:04
 * 文件说明:
 */
public class Demo1 {
    public static void main(String[] args) {
        Depot mDepot = new Depot(100);
        Producer mPro = new Producer(mDepot);
        Customer mCus = new Customer(mDepot);



        mPro.produce(60);
        mPro.produce(120);
        mCus.consumer(90);
        mCus.consumer(150);
        mPro.produce(110);

    }
}
