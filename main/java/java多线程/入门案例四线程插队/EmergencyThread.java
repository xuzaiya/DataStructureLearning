package java多线程.入门案例四线程插队;

public class EmergencyThread implements Runnable {
    public void run(){
        for (int i=0;i<6;i++){
            System.out.println(Thread.currentThread().getName()+"输出:"+i);
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
