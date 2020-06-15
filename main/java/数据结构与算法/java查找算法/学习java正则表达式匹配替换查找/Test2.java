package 数据结构与算法.java查找算法.学习java正则表达式匹配替换查找;

public class Test2 {
    public static void main(String[] args) {

        /*
        正则表达式的查找;主要是用到String类中的split();

        String str;

        str.split();方法中传入按照什么规则截取,返回一个String数组

        常见的截取规则:

        str.split("\\.")按照.来截取
        str.split(" ")按照空格截取
        str.split("cc+")按照c字符来截取,2个c或以上
        str.split((1)\\.+)按照字符串中含有2个字符或以上的地方截取(1)表示分组为1

        截取的例子;

        按照分组截取;截取的位置在两个或两个以上的地方
          */
        String str = "publicstaticccvoidddmain";
        //对表达式进分组重用
        String ragex1="(.)\\1+";
        String[] ss = str.split(ragex1);
        for(String st:ss){
            System.out.println(st);
        }
        //按照两个cc+来截取
        String ragex = " ";
        //切割
        String strs = "publicstaticccvoidddmain";
        String ragexs = "cc+";
        String[] s = strs.split(ragexs);
        for(String SSSS :s){
            System.out.println(SSSS);
        }
        System.out.println("=-=========");




    }
}
