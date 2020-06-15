package 数据结构与算法.java遍历算法.Java遍历Map对象的四种方式;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(2,3);
        map.put(3,3);
        map.put(4,3);
        map.put(5,3);
        map.put(6,3);


        Set<Map.Entry<Integer, Integer>> entries1 = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries1.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            Integer value = next.getValue();
            System.out.println("kye:"+key+"  "+"value:"+value);
        }





        /*// 方法一这是最常见的并且在大多数情况下也是最可取的遍历方式。在键值都需要时使用
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }



        // 在for-each循环中遍历keys或values。
        //遍历map中的键
        for (Integer key : map.keySet()) {
            System.out.println("Key = " + key);
        }
        //遍历map中的值
        for (Integer value : map.values()) {
            System.out.println("Value = " + value);
        }


        //方法三使用Iterator遍历
        // 使用泛型
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        // 不使用泛型
        Iterator entries2 = map.entrySet().iterator();
        while (entries2.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            Integer key = (Integer)entry.getKey();
            Integer value = (Integer)entry.getValue();
            System.out.println("Key = " + key + ", Value = " + value);
        }



        // 方法四 通过键值对遍历
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println("Key = " + key + ", Value = " + value);
        }*/





    }
}
