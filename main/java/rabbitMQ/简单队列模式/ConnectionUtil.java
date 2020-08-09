package rabbitMQ.简单队列模式;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author xuzaiya
 * @2020/7/16 9:31
 * 文件说明:
 */
public class ConnectionUtil {

    public static Connection getConnection() throws IOException {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务器地址
        factory.setHost("localhost");
        //设置端口号
        factory.setPort(5672);
        //设置账号信息、用户名，密码
        factory.setVirtualHost("/xuzaiya");
        factory.setUsername("xuzaiya");
        factory.setPassword("yx1994");
        //通过工厂获取连接
        Connection connection = factory.newConnection();
        return connection;

    }
}
