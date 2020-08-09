package rabbitMQ.订阅模式;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitMQ.简单队列模式.ConnectionUtil;

import java.io.IOException;

/**
 * @author xuzaiya
 * @2020/7/16 14:10
 * 文件说明:
 */
public class Send {

    private final static String EXCHANGE_NAME="test_exchange_fanout";

    public static void main(String[] args) throws Exception {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        //消息内容
        String message = "id=1001的商品已经更新了，搞啊";
        channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());
        System.out.println("[x] Sent "+message);
        channel.close();
        connection.close();
    }
}
