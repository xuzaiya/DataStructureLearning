package java设计模式.模式4建造者模式;
//指挥者类，用来指挥创建过程

public class Director {
    public void Construct(Builder builder){
        builder.builderPartA();
        builder.builderPartB();
    }
}
