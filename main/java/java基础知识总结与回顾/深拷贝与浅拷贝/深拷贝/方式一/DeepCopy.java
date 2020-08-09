package java基础知识总结与回顾.深拷贝与浅拷贝.深拷贝.方式一;
/*
*
* 与通过重写clone方法实现浅拷贝的基本思路一样，只需要为对象图的每一层的每一个对象都
* 实现Cloneable接口并重写clone方法，最后在最顶层的类的重写的clone方法中调用所有
* 的clone方法即可实现深拷贝。简单的说就是：每一层的每个对象都进行浅拷贝=深拷贝
*
*
*

*
*
* */
/* 层次调用clone方法实现深拷贝 */
public class DeepCopy {
    public static void main(String[] args) {
        Age a=new Age(20);
        Student stu1=new Student("摇头耶稣",a,175);
        
        //通过调用重写后的clone方法进行浅拷贝
        Student stu2=(Student)stu1.clone();
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
        System.out.println();
        
        //尝试修改stu1中的各属性，观察stu2的属性有没有变化
        stu1.setName("大傻子");
        //改变age这个引用类型的成员变量的值
        a.setAge(99);
        //stu1.setaAge(new Age(99));    使用这种方式修改age属性值的话，stu2是不会跟着改变的。因为创建了一个新的Age类对象而不是改变原对象的实例值
        stu1.setLength(216);
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
    }
}