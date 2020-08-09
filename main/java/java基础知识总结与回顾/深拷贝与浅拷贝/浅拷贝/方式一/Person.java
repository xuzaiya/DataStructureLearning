package java基础知识总结与回顾.深拷贝与浅拷贝.浅拷贝.方式一;

/**
 * @author xuzaiya
 * @2020/7/7 21:04
 * 文件说明:
 */
public class Person {
    //两个属性值：分别代表值传递和引用传递
    private Age age;
    private String name;
    public Person(Age age,String name) {
        this.age=age;
        this.name=name;
    }
    //拷贝构造方法
    public Person(Person p) {
        this.name=p.name;
        this.age=p.age;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String toString() {
        return this.name+" "+this.age;
    }
}
