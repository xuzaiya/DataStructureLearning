package java8.others;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("zhangsan",34);
        Person person2 = new Person("lisi",32);
        Person person3 = new Person("wangwu",20);

        List<Person> persons = Arrays.asList(person1,person2,person3);

        PersonTest test = new PersonTest();
        //List<Person> personResult = test.getPersonByUsername("zhangsan",persons);
        //personResult.forEach(person-> System.out.println(person.getUsername()));


        List<Person> personResult2 = test.getPersonByAge(20,persons);
        personResult2.forEach(person -> System.out.println(person.getAge()));



        List<Person> personResult3 = test.getPersonByAge2(20,persons,(age,personList)->{
            return personList.stream().filter(person -> person.getAge()>age).collect(Collectors.toList());
        });
        personResult3.forEach(person-> System.out.println(person.getAge()));
    }


    // 根据username 利用函数式编程
    public List<Person> getPersonByUsername(String username,List<Person> persons){
        return persons.stream().filter(person -> person.getUsername().equals(username)).collect(Collectors.toList());
    }


    // 根据age筛选
    public List<Person> getPersonByAge(int age,List<Person>persons){
        BiFunction<Integer,List<Person>,List<Person>> biFunction = (ageOfPerson,personList)->
             personList.stream().filter(person -> person.getAge()>ageOfPerson).collect(Collectors.toList());


        return biFunction.apply(age,persons);

    }




    public List<Person> getPersonByAge2(int age,List<Person>persons,BiFunction<Integer,List<Person>,List<Person>>biFunction){
        return biFunction.apply(age,persons);
    }

}
