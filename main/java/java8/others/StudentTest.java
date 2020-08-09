package java8.others;

import java.util.function.Supplier;

// Supplier函数式接口  ： 不接受参数 同时返回一个结果
public class StudentTest {
    public static void main(String[] args) {
        Supplier<Student> supplier = ()->new Student();
        System.out.println(supplier.get().getName());


        System.out.println("===============");
        Supplier<Student> supplier1 = Student::new;
        System.out.println(supplier1.get().getAge());


    }
}
