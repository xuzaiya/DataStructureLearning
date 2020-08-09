package java基础知识总结与回顾.深拷贝与浅拷贝.浅拷贝.方式一;

/**
 * @author xuzaiya
 * @2020/7/7 21:04
 * 文件说明:
 */
public class Age {
    private int age;
    public Age(int age) {
        this.age=age;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return getAge()+"";
    }
}
