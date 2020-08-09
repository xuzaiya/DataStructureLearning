package rabbitMQ.Work模式;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import rabbitMQ.简单队列模式.ConnectionUtil;
import 数据结构与算法.java队列.Queue;

import java.io.IOException;

/**
 * @author xuzaiya
 * @2020/7/16 11:04
 * 文件说明:
 */
public class Send {
    private final static String QUEUE_NAME = "test_queue_work";
    public static void main(String[] args) throws IOException, InterruptedException {
        //获取连接通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        for (int i=0;i<100;i++){
            String message = ""+i;
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            System.out.println("[x] Sent "+ message);
            Thread.sleep(i*10);
        }


    }

}
