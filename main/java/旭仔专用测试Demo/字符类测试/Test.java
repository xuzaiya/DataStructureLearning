package 旭仔专用测试Demo.字符类测试;

/**
 * @author xuzaiya
 * @2020/7/22 17:04
 * 文件说明:
 */
public class Test {
    public static void main(String[] args) {
        Parent c1 = new Child();
        Child c2 = new Child();
        System.out.println(c1.num1+"==="+c2.num1);
    }
}
