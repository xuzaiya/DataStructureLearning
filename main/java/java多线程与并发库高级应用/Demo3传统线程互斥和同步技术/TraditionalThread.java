package java多线程与并发库高级应用.Demo3传统线程互斥和同步技术;

public class TraditionalThread {
    public static void main(String[] args) {
        new TraditionalThread().init();
    }



    public void init(){
         Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("xuzaiya");
                }
            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("yangxu");
                }
            }
        }).start();
    }

    class Outputer{
        public synchronized void output(String name){
            int len =  name.length();
            for (int i=0;i<len;i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
}
