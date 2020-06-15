package java设计模式.模式4建造者模式;

public interface Builder {
    public void builderPartA();
    public void builderPartB();
    public Product getResult();
}
