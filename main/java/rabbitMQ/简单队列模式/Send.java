package rabbitMQ.简单队列模式;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @author xuzaiya
 * @2020/7/16 10:18
 * 文件说明:
 */
public class Send {
    private final static String QUEUE_NAME = "test_queue";

    public static void main(String[] args) throws IOException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //消息内容
        String message = "hello rabbitmq";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("[x] Sent "+ message);
        //关闭通道连接
        channel.close();
        connection.close();

    }
}
