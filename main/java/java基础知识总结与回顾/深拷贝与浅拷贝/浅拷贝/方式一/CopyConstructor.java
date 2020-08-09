package java基础知识总结与回顾.深拷贝与浅拷贝.浅拷贝.方式一;

import net.sf.json.util.JSONUtils;

/**
 * @author xuzaiya
 * @2020/7/7 21:03
 * 文件说明:
 *
 * 浅拷贝（Shallow Copy）：①对于数据类型是基本数据类型的成员变量，浅拷贝会直接进行值传递，
 * 也就是将该属性值复制一份给新的对象。因为是两份不同的数据，所以对其中一个对象的该成员变量值
 * 进行修改，不会影响另一个对象拷贝得到的数据。②对于数据类型是引用数据类型的成员变量，
 * 比如说成员变量是某个数组、某个类的对象等，那么浅拷贝会进行引用传递，也就是只是将该成员变量
 * 的引用值（内存地址）复制一份给新的对象。因为实际上两个对象的该成员变量都指向同一个实例。
 * 在这种情况下，在一个对象中修改该成员变量会影响到另一个对象的该成员变量值。
 *
 *
 * 通过拷贝构造方法实现浅拷贝：
 * 拷贝构造方法指的是该类的构造方法参数为该类的对象。
 * 使用拷贝构造方法可以很好地完成浅拷贝，
 * 直接通过一个现有的对象创建出与该对象属性相同的新的对象。
 */
public class CopyConstructor {
    public static void main(String[] args) {
        Age a=new Age(20);
        Person p1=new Person(a,"摇头耶稣");
        Person p2=new Person(p1);
        System.out.println("p1是"+p1);
        System.out.println("p2是"+p2);
        //修改p1的各属性值，观察p2的各属性值是否跟随变化
        p1.setName("小傻瓜");
        a.setAge(99);
        System.out.println("修改后的p1是"+p1);
        System.out.println("修改后的p2是"+p2);
    }

}
