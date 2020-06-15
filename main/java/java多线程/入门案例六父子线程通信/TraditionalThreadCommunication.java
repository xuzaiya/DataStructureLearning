package java多线程.入门案例六父子线程通信;

public class TraditionalThreadCommunication {
    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<50;i++){
                    business.sub();

                }

            }
        }).start();

        for (int i=0;i<50;i++){
            business.main();
        }

    }




}

class Business{
    private boolean ShouldSub = true;
    public synchronized  void sub()  {
        while (!ShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j < 10; j++) {
            System.out.println("sub Thread sequence of " + j + " loop of " + j);
        }
        this.notify();



        ShouldSub = false;

    }

    public synchronized void main(){
        while (ShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            for (int j = 0; j < 100; j++) {
                System.out.println("main Thread sequence of " + j + " loop of " + j);
            }

        this.notify();
        ShouldSub=!ShouldSub;

    }
}
