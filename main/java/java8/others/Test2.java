package java8.others;

@FunctionalInterface
 interface MyInterface {
    void test();

    //void test2();

    String toString(); // 重写了java.lang.Object类的方法 就不会让这个接口的抽象方法加1
}

public class Test2{
    public void myTest(MyInterface myInterface){
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }
    public static void main(String[]args){
        Test2 test2 = new Test2();
        // 匿名内部类
        /*test2.myTest(new MyInterface() {
            @Override
            public void test() {
                System.out.println("mytest");
            }
        });*/

        //用lambda改进
        test2.myTest(()-> System.out.println("mytest"));

        //进一步
        MyInterface myInterface = ()-> System.out.println("mytest");
        System.out.println(myInterface.getClass());//class com.chongqing.jdk8.Test2$$Lambda$2/1831932724
        System.out.println(myInterface.getClass().getSuperclass());//class java.lang.Object
        System.out.println(myInterface.getClass().getInterfaces().length); // 1
        System.out.println(myInterface.getClass().getInterfaces()[0]); // interface com.chongqing.jdk8.MyInterface
    }
}


