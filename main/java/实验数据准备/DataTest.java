package 实验数据准备;

import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/27 08:43
 * @Description: # 类的描述
 */
public class DataTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Map<String ,String> map = new HashMap<>();
        map.put("12","yangxu");
        map.put("12","yank");

        System.out.println(map.get("12"));

    }

}
