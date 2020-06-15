package 数据结构与算法.java遍历算法.使用LinkList模拟堆栈;

import java.util.LinkedList;

public class Test {



    public static void main(String[] args) {
        Duilie dl = new Duilie();
        dl.myAdd("java01");
        dl.myAdd("java02");
        dl.myAdd("java03");
        dl.myAdd("java04");
        while(!dl.isNull()){
            System.out.println(dl.myGet());
        }
    }



}
