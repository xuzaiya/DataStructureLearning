package java设计模式.模式8策略模式;

/*
*  通俗来讲：策略模式对应于解决某一个问题的一个算法族，允许用户从该算法族中任选一个算法解决某一问题，
*  同时可以方便的更换算法或者增加新的算法。并且由客户端决定调用哪个算法。


开发中常见的场景：

JAVASE中GUI编程中，布局管理 ；
Spring框架中，Resource接口，资源访问；
javax.servlet.http.HttpServlet#service()；
如果一个方法有大量if else语句，可通过策略模式来消除掉；
一个系统，需要动态地在几个算法中选择一种，可用策略模式实现；
系统有很多类，而他们的区别仅仅在于他们的行为不同
策略模式的优点：

开闭原则；
避免使用多重条件转移语句；
提高了算法的保密性和安全性：可使用策略模式以避免暴露复杂的，与算法相关的数据结构。
策略模式体现了面向对象程序设计中非常重要的两个原则：

封装变化的概念。
编程中使用接口，而不是使用的是具体的实现类(面向接口编程)。

 * */
public class TestStrategy {
    public static void main(String[] args) {
        Environment e = new Environment(new AddStrategy());
        int value = e.calculate(5, 7);
        System.out.println("a+b="+value);


        Environment r = new Environment(new SubStrategy());
        System.out.println("a-b="+r.calculate(9,3));

    }
}
