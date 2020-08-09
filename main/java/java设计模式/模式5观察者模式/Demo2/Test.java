package java设计模式.模式5观察者模式.Demo2;

import java.nio.file.Watchable;

/**
 * @author xuzaiya
 * @2020/6/25 14:51
 * 文件说明:
 */
public class Test {
    public static void main(String[] args) {

        WechatServer server = new WechatServer();

        Observer userzhang = new User("zhangsan");
        Observer userList = new User("lisi");
        Observer userWang  = new User("wangwu");


        server.registerObserver(userzhang);
        server.registerObserver(userList);
        server.registerObserver(userWang);


        server.setInfomation("PHP是世界上最好用的语言");
        System.out.println("======================");;
        server.registerObserver(userzhang);
        server.setInfomation("java是世界上最好的语言");

    }
}
