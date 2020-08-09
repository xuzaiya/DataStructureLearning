package 旭仔专用测试Demo.字符类测试;


import java.lang.reflect.Field;

/**
 * @author xuzaiya
 * @2020/6/28 20:56
 * 文件说明:
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
       Son son = new Son();
        Class<? extends Son> aClass = son.getClass();
        Field name = aClass.getField("name");
        System.out.println(name);
        Field[] declaredField = aClass.getDeclaredFields();
        System.out.println(declaredField.length);


    }
}
