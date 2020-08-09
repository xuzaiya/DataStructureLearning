package java设计模式.模式5观察者模式.Demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuzaiya
 * @2020/6/25 14:43
 * 文件说明:被观察者，也就是微信公众号服务
 * 实现了Observerable 接口，对Observerable接口的三个方法进行了具体的实现
 */
public class WechatServer implements Observerable {


    private List<Observer> list;
    private String message;


    public WechatServer(){
        list = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty()){

            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i =0;i<list.size();i++){
            Observer oserver = list.get(i);
            oserver.update(message);
        }
    }


    public void setInfomation(String s){
        this.message = s;
        System.out.println("微信服务更新消息："+s);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
