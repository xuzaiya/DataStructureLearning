package 旭仔专用测试Demo;

/**
 * @author xuzaiya
 * @2020/7/22 16:09
 * 文件说明:
 */
public class Test {
    static void funcA(A a){
        a.a();
    }
    static void funcB(B b){
        b.b();
    }

    public static void main(String[] args) {
        ClassC c = new ClassC();
        funcA(c);
        funcB(c);
    }
}
