package java设计模式.模式7代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/*
* 总结：以上代码只有标黄的部分是需要自己写出，其余部分全都是固定代码。
* 由于java封装了newProxyInstance这个方法的实现细节，所以使用起来才能这么方便，
* 具体的底层原理将会在下一小节说明。

缺点：可以看出静态代理和JDK代理有一个共同的缺点，就是目标对象必须实现一个或多个
接口，假如没有，则可以使用Cglib代理。
* */
public class Test {
    public static void main(String[] args) {
        Singer target = new Singer();
        ISinger proxy = (ISinger) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("向观众问好");
                Object returnValue = method.invoke(target, args);
                System.out.println("谢谢大家");
                return returnValue;
            }
        });
        proxy.sing();
    }
}
