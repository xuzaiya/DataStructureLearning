package java8.others;

import java.util.Optional;

public class optionalTest {
    public static void main(String[] args) {
        //Optional<String> optional = Optional.empty();
        Optional<String> optional = Optional.of("hello");


        if (optional.isPresent()){
            System.out.println(optional.get());
        }

        // 推荐的optional使用的方式
        //optional.ifPresent(item-> System.out.println(item));
        //=============================
        //System.out.println(optional.orElse("world"));

        //============================
        System.out.println(optional.orElseGet(()->"nihao"));

        Optional<String> optional1 = Optional.ofNullable("yangxu");

    }

}
