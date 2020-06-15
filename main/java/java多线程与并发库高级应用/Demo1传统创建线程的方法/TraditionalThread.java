package java多线程与并发库高级应用.Demo1传统创建线程的方法;

public class TraditionalThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            public void run(){
                while(true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            }
        };
        thread.start();

          /*  for (int i=0;i<10000;i++){
                Thread.sleep(300);
                System.out.println(i);
            }*/


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });
        thread1.start();


        new Thread(){
            public void run(){
                System.out.println("angxu");
            }
        }.start();


        new Thread(
                new Runnable(){
                    public void run(){
                        System.out.println("nihao ");

                    }
                }
        ){}.start();

    }
}
