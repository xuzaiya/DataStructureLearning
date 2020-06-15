package java多线程.入门案例五多线程之间通信;

public class Test {
    public static void main(String[] args) {
        Storage st = new Storage();
        Input input = new Input(st);
        Output output = new Output(st);
        new Thread(input).start();
        new Thread(output).start();
    }
}
