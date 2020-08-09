package rabbitMQ.rabbitmq消息确认机制之事务;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import rabbitMQ.简单队列模式.ConnectionUtil;

/**
 * @author xuzaiya
 * @2020/7/16 15:38
 * 文件说明:
 */
public class TxRecv {

    private static final String QUEUE_NAME="test_queue_tx";

    public static void main(String[] args)throws Exception {
        //获取连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列，自动
        channel.basicConsume(QUEUE_NAME,true,consumer);
        //获取消息
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("[x] Received "+message );
            //休眠
            Thread.sleep(1000);
        }


    }
}
