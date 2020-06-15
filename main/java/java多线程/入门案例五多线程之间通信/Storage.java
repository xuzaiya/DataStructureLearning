package java多线程.入门案例五多线程之间通信;

public class Storage {
    private int[] cells = new int[10];
    private int inPos,outPos;
    private int count;
    public synchronized void put(int num){
        try{
            while (count == cells.length){
                this.wait();

            }
            cells[inPos] = num;
            System.out.println("在cells["+inPos+"]中放入数据---"+cells[inPos]);
            inPos++;
            if (inPos == cells.length)
                inPos =0;
            count++;
            Thread.sleep(500);
            this.notify();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public synchronized  void get(){
        try{
            while (count == 0){
                this.wait();
            }
            int data = cells[outPos];
            System.out.println("从cells["+outPos+"]中取出数据"+data);
            cells[outPos] = 0;
            outPos++;
            if (outPos == cells.length){
                outPos=0;
            }
            count--;
            Thread.sleep(500);
            this.notify();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
