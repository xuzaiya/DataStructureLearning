package java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {
    public static void main(String[] args) {
        // 分组
        Student student1 = new Student("zhangsan",100,20);
        Student student2 = new Student("lisi",90,20);
        Student student3 = new Student("wangwu",90,30);
        Student student4 = new Student("zhangsan",80,40);

        List<Student> studentList = Arrays.asList(student1,student2,student3,student4);

        //根据名字分组
        //Map<String,List<Student>> studentmap  = studentList.stream().collect(Collectors.groupingBy(Student::getName));
        //System.out.println(studentmap);

        //根据分数分组
        //Map<Integer,List<Student>> studentmap2 = studentList.stream().collect(Collectors.groupingBy(Student::getScore));
        //System.out.println(studentmap2);

        //按照名字分组，并返回分组的个数
        //Map<String,Long> studentmap3 = studentList.stream().collect(Collectors.groupingBy(Student::getName,Collectors.counting()));
        //System.out.println(studentmap3);

        //分组 求平均值
        //Map<String,Double>studentmap4 = studentList.stream().collect(Collectors.groupingBy(Student::getName,Collectors.averagingDouble(Student::getScore)));
        //System.out.println(studentmap4);


        /*
        分组：group by
        分区：partition by  (分区是分组的一种特例，只会分成两组 true 和  false)
         */
        Map<Boolean,List<Student>> studentmap5 = studentList.stream().collect(Collectors.partitioningBy(student->student.getScore()>90));
        System.out.println(studentmap5);

    }
}
