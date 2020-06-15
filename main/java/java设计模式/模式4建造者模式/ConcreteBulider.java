package java设计模式.模式4建造者模式;

public class ConcreteBulider implements Builder {

    private Product product = new Product();
    @Override
    public void builderPartA() {
        product.add("部件A");
    }

    @Override
    public void builderPartB() {
        product.add("部件B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
