package rabbitMQ.rabbitmq消息确认机制之事务;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitMQ.简单队列模式.ConnectionUtil;

import java.io.IOException;

/**
 * @author xuzaiya
 * @2020/7/16 15:38
 * 文件说明:
 */
public class TxSend {
    private static final String QUEUE_NAME="test_queue_tx";

    public static void main(String[] args) throws IOException {
        //获取连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String message  ="hello tx message";
        try{
            channel.txSelect();//开启事务
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            int i = 1/0;
            channel.txCommit();


        }catch (Exception e){
            channel.txRollback();
            System.out.println("send message rollback");
        }
    }
}
