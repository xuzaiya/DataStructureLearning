package 数据结构与算法.java查找算法.学习java正则表达式匹配替换查找;

public class Test3 {
    public static void main(String[] args) {
        // 替换
       /*  String str="wei232123jin234";
        String ragex = "\\d{4,}";
        String newstr = " ";
        String s =str.replaceAll(ragex, newstr);
        System.out.println(s); */


        String strs = "我...我...要..要.吃...吃...饭";
        String regex = "\\.+";
        String newStr = "";
        strs=test(strs, regex, newStr);
        System.out.println(strs);
        regex = "(.)\\1+";
        newStr = "$1";
        test(strs, regex, newStr);
    }

    public static String test(String str, String regex, String newStr) {
        String str2 = str.replaceAll(regex, newStr);
        System.out.println(str2);
        return str2;
    }


}
