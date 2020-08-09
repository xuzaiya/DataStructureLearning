package java8.others;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalTest2 {
    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setName("zhangsan");

        Employee employee1 = new Employee();
        employee1.setName("lisi");

        Company company = new Company();
        company.setName("company1");
        List<Employee> employees = Arrays.asList(employee,employee1);
        company.setEmployees(employees);

        List<Employee> list = company.getEmployees();
        Optional<Company> optional = Optional.ofNullable(company);
        //  optional通常作为方法的返回值 用来规避空指针异常  不要讲optional作为方法的参数或者在函数内声明optional类型的成员变量
        System.out.println(optional.map(theCompany->theCompany.getEmployees()).orElse(Collections.emptyList()));

        // 方法引用可以认为是lambda表达式的语法糖  或者是一个特殊情况

    }
}
