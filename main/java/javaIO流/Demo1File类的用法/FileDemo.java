package javaIO流.Demo1File类的用法;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        //File类静态成员变量
        //与系统有关的路径分隔符
        String separator = File.pathSeparator;
        System.out.println(separator);// 是一个分号,目录的分割   Linux :

        //与系统有关的默认名称分隔符
        separator = File.separator;
        System.out.println(separator);// 向右 \  目录名称分割  Linux /
    }
}
