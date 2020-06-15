package java基础知识总结与回顾.常见的控制台输入方法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {

        //1.使用标准输入串System.in  一次只读入一个字节数据
        //int read =(char) System.in.read();
        //System.out.println("您的输入是："+read);


        //2.使用Scanner取得一个字符串或一组数字
        Scanner scan = new Scanner(System.in);
        //String read = scan.nextLine(); //输入一行字符串
        int value = scan.nextInt(); //输入一个整数  // double float  long 同理
        System.out.println(value);
        //System.out.println("输入的数据是："+read);

        //3.使用BufferedReader取得含空格的输入
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
        //String read = null;
        //System.out.println("输入数据：");
        //read = br.readLine();
        //System.out.println(read);


    }
}
