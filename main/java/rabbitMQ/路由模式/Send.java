package rabbitMQ.路由模式;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitMQ.简单队列模式.ConnectionUtil;

import java.io.IOException;

/**
 * @author xuzaiya
 * @2020/7/16 14:48
 * 文件说明:
 */
public class Send {
    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws IOException {
        //获取连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        //消息内容
        String message = "hello world";
        channel.basicPublish(EXCHANGE_NAME,"insert",null,message.getBytes());
        System.out.println("后台系统："+message);
        channel.close();
        connection.close();

    }
}
