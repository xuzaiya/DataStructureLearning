package java设计模式.模式4建造者模式;

public class ConcreteBuilder2 implements Builder {
    private Product product = new Product();

    @Override
    public void builderPartA() {
        product.add("部件X");
    }

    @Override
    public void builderPartB() {
        product.add("部件y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
