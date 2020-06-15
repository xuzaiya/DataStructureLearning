package 数据结构与算法.java遍历算法.java中List集合及其遍历详解;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/*
1. 首先List<E>集合继承与Collection<E>，是一个接口。

   ①  Collection (集合框架是JDK1.2版本出现的)

   ②   list:是有序的，元素可以重复，以为该集合体系有索引。

 　　　　   经常用到的是实现该接口的ArrayList和LinkedList类

   ③   Arraylist:  底层的数据结构使用的是数组结构，

 　　　　　　特点： 查询速度很快，但是增删稍慢。线程不同步

         LinkedList： 底层使用的是链表数据结构。

 　　　　　　特点： 增删速度很快，查询稍慢。

         Vector：（JDK1.0版本出现的） 底层是数组数据结构，线程同步。被ArrayList替代了。（已经不用了）
  */

// List 的两种遍历方式
public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println("........第一种遍历方式：for遍历......");
        for (Object li : list) {
            System.out.println(li);
        }

        System.out.println("........第二种遍历方式：ListIterator迭代遍历......");

        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println(obj);
        }
    }



}
