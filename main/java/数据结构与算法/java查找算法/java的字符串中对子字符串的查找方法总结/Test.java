package 数据结构与算法.java查找算法.java的字符串中对子字符串的查找方法总结;
/*
Java中字符串中子串的查找共有四种方法，如下：
1、int indexOf(String str) ：返回第一次出现的指定子字符串在此字符串中的索引。
2、int indexOf(String str, int startIndex)：从指定的索引处开始，返回第一次出现的指定子字符串在此字符串中的索引。
3、int lastIndexOf(String str) ：返回在此字符串中最右边出现的指定子字符串的索引。
4、int lastIndexOf(String str, int startIndex) ：从指定的索引处开始向后搜索，返回在此字符串中最后一次出现的指定子字符串的索引。

indexof()用法说明

?
1
indexof()
返回 String 对象内第一次出现子字符串的字符位置。

?
1
string.indexOf(subString[, startIndex])
参数

?
1
string
必选项。String 对象或文字。

subString 必选项。

要在 String 对象中查找的子字符串。

starIndex 可选项。

该整数值指出在 String 对象内开始查找的索引。如果省略，则从字符串的开始处查找。

说明
indexOf 方法返回一个整数值，指出 String 对象内子字符串的开始位置。如果没有找到子字符串，则返回-1。

如果 startindex 是负数，则 startindex 被当作零。如果它比最大的字符位置索引还大，则它被当作最大的可能索引。

从左向右执行查找。否则，该方法与 lastIndexOf 相同。
  */
public class Test {
    private static int counter = 0;
    /*
       @param args
      */
    public static void main(String[] args)
    {
        String str ="sdSS  &HGJhadHCASch& ^^";
        int i = stringNumbers(str);
        System.out.println(i);
    }

    public static int stringNumbers(String str)
    {
        if (str.indexOf("java")==-1)
        {
            return 0;
        }
        else if(str.indexOf("java") != -1)
        {
            counter++;
            stringNumbers(str.substring(str.indexOf("java")+4));
            return counter;
        }
        return 0;
    }

}
