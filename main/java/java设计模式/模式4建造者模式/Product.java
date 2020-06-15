package java设计模式.模式4建造者模式;

import java.util.ArrayList;
import java.util.List;

public class Product {
    List<String> parts = new ArrayList<>();
    //添加产品部件
    public void add(String part){
        parts.add(part);
    }

    //列举所有的产品部件
    public void show(){
        System.out.println("\n产品创建------");
        for (String item: parts){
            System.out.println(item);
        }
    }
}
