package Java多线程.java多线程与并发库高级应用.Demo3传统线程互斥和同步技术;

/*
 * 子线程循环10次，接着主线程循环100次，接着又回到子线程循环10次，接着
 * 再回到主线程循环100次，如此循环50次
 * */
public class TraditionalThreadCommunication {
    public static void main(String[] args) {
        Business business = new Business();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.subThread(i);
                }
            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            business.mainThread(i);
        }


    }
}


class Business {
    private boolean bShouldSub = true;

    // if 可以换成  while  效果更健壮
    public synchronized void subThread(int j) {
        while (!bShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println("sub Thread sequene of " + i+" loop of "+ j);
        }
        bShouldSub =false;
        this.notify();


    }


    public synchronized void mainThread(int j) {
        while (bShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i <= 100; i++) {
            System.out.println("main Thread sequene of " + i+" loop of "+ j);
        }
        bShouldSub = true;
        this.notify();

    }
}
