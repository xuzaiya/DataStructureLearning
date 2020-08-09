package rabbitMQ.spring集成rabbitmq;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/20 08:26
 * @Description: # 类的描述
 */
public class SpringMain {

    public static void main(String[] args) throws InterruptedException {
         AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:rabbitmq-context.xml");
        //RabbitMQ模板
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);

        //发送消息
        template.convertAndSend("yangxutyangdkjfkdjfk");
        Thread.sleep(1000);
        ctx.destroy();//容器销毁
    }
}
