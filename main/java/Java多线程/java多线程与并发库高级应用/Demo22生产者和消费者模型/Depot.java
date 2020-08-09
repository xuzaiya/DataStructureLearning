package Java多线程.java多线程与并发库高级应用.Demo22生产者和消费者模型;

/**
 * @author xuzaiya
 * @2020/7/5 16:45
 * 文件说明:仓库
 *
 *生产/消费者问题是个非常典型的多线程问题，涉及到的对象包括“生产者”、“消费者”、“仓库”和“产品”。他们之间的关系如下：
 * (01) 生产者仅仅在仓储未满时候生产，仓满则停止生产。
 * (02) 消费者仅仅在仓储有产品时候才能消费，仓空则等待。
 * (03) 当消费者发现仓储没产品可消费时候会通知生产者生产。
 * (04) 生产者在生产出可消费产品时候，应该通知等待的消费者去消费。
 *
 *
 */
public class Depot {
    private int capacity;//仓库的容量
    private int size;//仓库的实际数量

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public synchronized void produce(int val){
        try {
            int left = val; //left 表示想要生产的数量
            while(left>0){
                //库存已满时，等待“消费者”消费产品
                while(size>=capacity){ wait();}
                    //获取“实际生产的数量”(即库存中新增的数量)
                    // 如果“库存”+“想要生产的数量”>“总的容量”，则“实际增量”=“总的容量”-“当前容量”。(此时填满仓库)
                    // 否则“实际增量”=“想要生产的数量”
                    int inc = (size + left)>capacity? (capacity-size):left;
                    size +=inc;
                    left -=inc;
                    System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n", Thread.currentThread().getName(), val, left, inc, size);
                    notifyAll();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void consume(int val){
        try {
            //left表示“客户要消费的数量”（有可能消费的数量太大，库存不够，需多次消费）
            int left = val;
            while(left>0){
                //库存为0时，等待生产者生产产品
                while(size<=0){ wait();}
                    // 获取“实际消费的数量”(即库存中实际减少的数量)
                    // 如果“库存”<“客户要消费的数量”，则“实际消费量”=“库存”；
                    // 否则，“实际消费量”=“客户要消费的数量”。
                    int dec = (size<left)? size:left;
                    size -= dec;
                    left -= dec;
                    System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",Thread.currentThread().getName(), val, left, dec, size);
                    notifyAll();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public String toString(){
        return "capacity:"+capacity+", actual size:"+size;
    }
}
