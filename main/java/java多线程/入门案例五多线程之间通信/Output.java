package java多线程.入门案例五多线程之间通信;

public class Output implements  Runnable {
    private Storage st;
    public Output(Storage st){
        this.st =st;
    }

    public void run(){
        while (true){
            st.get();
        }
    }
}
