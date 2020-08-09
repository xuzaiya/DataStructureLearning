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
public class Recv1 {
    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] args) throws IOException, InterruptedException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        //同一时刻服务器之后发送一条消息给消费者
        channel.basicQos(1);
        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列 自动返回完成，第二个参数为true
        channel.basicConsume(QUEUE_NAME, true, consumer);
        //获取消息
        while (true) {
            //自动模式，不用给服务器发送反馈
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("[x] Received " + message);


        }
    }
}


