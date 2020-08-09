package 旭仔专用测试Demo;

/**
 * @author xuzaiya
 * @2020/7/22 15:47
 * 文件说明:
 */
public class SC {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(1005);
        DrawThread dt1 = new DrawThread(account);
        DrawThread dt2 = new DrawThread(account);
        DrawThread dt3 = new DrawThread(account);
        dt1.start();
        dt2.start();
        dt3.start();


        dt1.join();
        dt2.join();
        dt3.join();
        System.out.println("账户余额为："+account.Balance);


    }
}
