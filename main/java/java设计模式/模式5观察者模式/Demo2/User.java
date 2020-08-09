package java设计模式.模式5观察者模式.Demo2;

/**
 * @author xuzaiya
 * @2020/6/25 14:49
 * 文件说明:
 */
public class User implements Observer{

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "接收到推送消息： "+message);
    }
}
