package rabbitMQ.rabbitmq消息确认机制之confirm串行;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import rabbitMQ.简单队列模式.ConnectionUtil;


import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/21 14:04
 * @Description: # 类的描述
 */
public class Send3 {
    private static final String QUEUE_NAME="test_queue_confirm3";

    public static void main(String[] args)throws Exception {
        //获取连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //生产者调用confirmSelect 将channel设置为confirm模式
        channel.confirmSelect();
        //存放的是未确认的消息
        final SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());
        //通道添加监听
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                if (multiple){
                    System.out.println("--------handleAck--------mutiple");
                    confirmSet.headSet(deliveryTag+1).clear();
                }else{
                    System.out.println("--------handleAck--------mutiple  false");
                    confirmSet.remove(deliveryTag);
                }
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                if (multiple){
                    System.out.println("--------handleNack--------mutiple");
                    confirmSet.headSet(deliveryTag+1).clear();
                }else{
                    System.out.println("--------handleNack--------mutiple  false");
                    confirmSet.remove(deliveryTag);
                }
            }
        });


        String message = "hello confirm message";


        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());


        while(true){
            long seqNo = channel.getNextPublishSeqNo();
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            confirmSet.add(seqNo);
        }


    }
}
