package Java多线程.java多线程与并发库高级应用.Demo18Callable案例;

import java.util.concurrent.Callable;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/21 16:23
 * @Description: # 类的描述
 */
public class MyCallable implements Callable {
    String i ;
    @Override
    public String call() throws Exception {
        return i;
    }
    public MyCallable(String i){
        this.i = i ;
    }
}
