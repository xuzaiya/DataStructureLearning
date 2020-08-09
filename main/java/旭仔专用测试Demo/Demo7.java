package 旭仔专用测试Demo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuzaiya
 * @2020/7/16 8:58
 * 文件说明:
 */
public class Demo7 {
    public static void main(String[] args) {
        char[] ch = new char[]{'y','x','z'};
        List<Character> list = new String(ch).chars().mapToObj(i->(char)i).collect(Collectors.toList());
        list.stream().map(Character::toUpperCase).forEach(System.out::println);
        list.forEach(System.out::println);
    }
}
