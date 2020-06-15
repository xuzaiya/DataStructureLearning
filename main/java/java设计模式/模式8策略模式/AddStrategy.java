package java设计模式.模式8策略模式;


//定义具体的加法策略角色

public class AddStrategy implements Strategy {
    @Override
    public int calc(int num1, int num2) {
        return num1+num2;
    }
}
