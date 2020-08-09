package java8.others;

import java.util.function.Supplier;

// supplier  供应商   不接受参数返回一个结果
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> supplier = ()->"hello world";
        System.out.println(supplier.get());

    }
}
