package 数据结构与算法.正则表达式;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
网络爬虫去链接
 */
public class WebSpiderTest {
    public static void main(String[] args) {
        String str = getURLContent("http://www.163.com","gbk");
       List<String> result = getMatherSubstrs(str,"href=\"([\\w\\s./:]+?)\"");
        for (String strs :result){
            System.out.println(strs);
        }


    }

    //获取url对应网页的内容
    public static String getURLContent(String urlStr,String charset){
        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL(urlStr);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName(charset)));
            String temp = "";
            while((temp =reader.readLine())!=null){
                sb.append(temp);
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    public static List<String> getMatherSubstrs(String destStr,String regexStr) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(regexStr);
        Matcher matcher = pattern.matcher(destStr);
        while (matcher.find()) {
            result.add(matcher.group(1));
        }
        return result;
    }
}
