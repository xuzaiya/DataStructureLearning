package 数据结构与算法.java遍历算法.使用LinkList模拟堆栈;

import java.util.LinkedList;

public class Duilie {

        private LinkedList<Object> link;
        Duilie(){
            link = new LinkedList<Object>();
        }
        public void myAdd(Object obj){
            link.addFirst(obj);
        }
        public Object myGet(){
            return link.removeLast();//先进先出---若要改成先进后出，将removelast()改成removeFirst（）
        }
        public boolean isNull(){
            return link.isEmpty();
        }

}
