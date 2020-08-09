package Java多线程.java多线程与并发库Demo.入门案例五多线程之间通信;

public class Input implements  Runnable {
    private Storage st;
    private int num=0;
    public Input(Storage st){
        this.st = st;
    }
    public void run(){
        while (true){
            st.put(num++);
        }
    }


}
