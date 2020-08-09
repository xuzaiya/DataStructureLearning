package 旭仔专用测试Demo;

/**
 * @author xuzaiya
 * @2020/7/22 15:59
 * 文件说明:
 */
public class BB extends AA {
    static {
        System.out.println("BB.static");
    }
    {
        System.out.println("BB.{}");
    }

    public static void main(String[] args) {
        BB b = new BB();
    }
}
