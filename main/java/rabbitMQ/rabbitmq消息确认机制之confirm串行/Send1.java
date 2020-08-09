package rabbitMQ.rabbitmq消息确认机制之confirm串行;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitMQ.简单队列模式.ConnectionUtil;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/21 14:04
 * @Description: # 类的描述
 */
public class Send1 {
    private static final String QUEUE_NAME="test_queue_confirm1";

    public static void main(String[] args)throws Exception {
        //获取连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String message = "hello confirm message";
        //生产者调用confirmSelect 将channel设置为confirm模式
        channel.confirmSelect();
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        //单条发送
        if(!channel.waitForConfirms()){

            System.out.println("message send failed");
        }else {
            System.out.println("message send ok");
        }
        channel.close();
        connection.close();


    }
}
