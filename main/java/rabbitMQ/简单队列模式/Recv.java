package rabbitMQ.简单队列模式;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;


import java.io.IOException;

/**
 * @author xuzaiya
 * @2020/7/16 10:21
 * 文件说明:
 */
public class Recv {
    private final static String QUEUE_NAME = "test_queue";

    public static void main(String[] args) throws IOException, InterruptedException {
        //获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列
        channel.basicConsume(QUEUE_NAME,true,consumer);
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("[x] Received "+message);
        }


    }
}


