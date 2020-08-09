package rabbitMQ.spring集成rabbitmq;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/21 15:06
 * @Description: # 类的描述
 */
public class MyConsumer {

    //具体执行业务的方法
    public void listen(String foo){
        System.out.println("消费者："+foo);
    }

}
