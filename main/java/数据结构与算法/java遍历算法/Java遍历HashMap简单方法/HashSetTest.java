package 数据结构与算法.java遍历算法.Java遍历HashMap简单方法;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("c", "cc");
        map.put("d", "dd");
        map.put("e", "ee");
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            String key =(String) iterator.next();
            String value =(String) map.get(key);
            System.out.println("key:"+key+" "+"value:"+value);
            //System.out.println(iterator.next());
        }



        /*for(Iterator itr = set.iterator(); itr.hasNext();){
            String value =(String) itr.next();
            String key = (String)map.get(value);
            System.out.println(value+"="+key);
        }*/
    }
}
