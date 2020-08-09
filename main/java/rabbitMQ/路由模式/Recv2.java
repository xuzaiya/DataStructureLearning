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
public class Recv2 {
    private final static String QUEUE_NAME = "test_queue_direct_2";
    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws IOException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //绑定队列到交换器上
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"delete");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"add");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"insert");
        //同意时刻服务器只会发送一条消息给消费者
        channel.basicQos(1);
        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME,false,consumer);

    }
}
