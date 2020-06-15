package java设计模式.模式8策略模式;
//定义环境角色，负责和具体的策略类交互，内部持有一个策略类的引用，给客户端用
public class Environment {
    private Strategy strategy;
    public Environment(Strategy strategy){
        this.strategy = strategy;
    }
    public int calculate(int a,int b){
        return strategy.calc(a,b);
    }
}
