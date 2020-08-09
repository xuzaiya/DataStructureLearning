package rabbitMQ.Work模式;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import rabbitMQ.简单队列模式.ConnectionUtil;

import java.io.IOException;

/**
 * @author xuzaiya
 * @2020/7/16 11:04
 * 文件说明:
 */
public class Recv2 {
    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] args) throws Exception {
        //获取连接通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        channel.basicQos(1);
        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME,false,consumer);
        //获取消息
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("[x] Received "+message );
            //休眠
            Thread.sleep(1000);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        }
    }

}
