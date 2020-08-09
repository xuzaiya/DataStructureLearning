package rabbitMQ.路由模式;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import rabbitMQ.简单队列模式.ConnectionUtil;

import java.io.IOException;

/**
 * @author xuzaiya
 * @2020/7/16 14:48
 * 文件说明:
 */
public class Recv1 {
    private final static String QUEUE_NAME = "test_queue_direct_1";
    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws Exception {

        //获取连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //绑定队列到交换器上
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"update");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"select");

        //同一时刻服务器只会发送一条消息给消费者
        channel.basicQos(1);
        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        /* 监听队列，手动返回完成 */
        channel.basicConsume(QUEUE_NAME,false,consumer);
        //获取消息
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("前台系统 : "+message);
            Thread.sleep(10);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);

        }
    }
}
