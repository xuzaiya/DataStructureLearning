package java8.methodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest {
    //Supplier 不接受参数 并且返回一个String类型的结果
    public String getString(Supplier<String>supplier){
        return supplier.get()+"test";
    }

    public String getString2(String str,Function<String,String>function){
        return function.apply(str);
    }

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan",10);
        Student student2 = new Student("lisi",90);
        Student student3 = new Student("wangwu",50);
        Student student4 = new Student("zhaoliu",60);

        List<Student> studentList = Arrays.asList(student1,student2,student3,student4);

        //第一种  类名::静态方法

        // 按照名字排序
        //studentList.sort((param1,param2)->Student.compareStudentByName(param1,param2));
        //studentList.forEach(System.out::println);
        //studentList.forEach(item-> System.out.println(item));

        // 按照名字排序
        //studentList.sort(Student::compareStudentByName);
        //studentList.forEach(item-> System.out.println(item));

        // 按照分数排序
        //studentList.sort(Student::compareStudentByScore);
        //studentList.forEach(item-> System.out.println(item));

        //第二种 对象::实例方法
        /*StudentComparator studentComparator = new StudentComparator();
        studentList.sort((param1,param2)->studentComparator.compareStudentByScore(param1,param2));
        studentList.forEach((item)-> System.out.println(item));

        studentList.sort((param1,param2)->studentComparator.compareStudentByName(param1,param2));
        studentList.forEach(item-> System.out.println(item));

        studentList.sort(studentComparator::compareStudentByName);
        studentList.sort(studentComparator::compareStudentByScore);*/

        //第三种  类名::实例方法
        //sort方法需要接受两个参数  compareByName是实例方法  一定有一个对象调用它  sort里面接受的lambda表达式的第一个参数调用的comparebyName
        //后续的参数作为compareByName的参数穿进去
        /*studentList.sort(Student::compareByName);
        studentList.forEach(item-> System.out.println(item));

        studentList.sort(Student::compareByScore);
        studentList.forEach(item-> System.out.println(item));*/

       /* List<String> cities = Arrays.asList("qingdao","chongqing","tianjin","beijing");
        Collections.sort(cities,(city1,city2)->city1.compareToIgnoreCase(city2));
        cities.forEach(city-> System.out.println(city));

        Collections.sort(cities,String::compareToIgnoreCase);
        cities.forEach(System.out::println);*/


        //第四种   构造方法引用：类名::new
        //MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
        //System.out.println(methodReferenceTest.getString(()->new String("nihao")));
        //System.out.println(methodReferenceTest.getString(String::new));
        //System.out.println(methodReferenceTest.getString(()->new String("nihao")));


        //System.out.println(methodReferenceTest.getString2("hello",(item)-> item));
        //System.out.println(methodReferenceTest.getString2("hello",String::new));
    }
}
