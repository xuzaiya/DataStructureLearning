package 旭仔专用测试Demo;

import java.security.spec.DSAGenParameterSpec;

/**
 * @author xuzaiya
 * @2020/7/22 15:43
 * 文件说明:
 */
public class Account {
    int Balance;
    public Account(int _balence){
        this.Balance = _balence;
    }

    public void getMoney(int money){
        if(Balance>=money){
            Balance -=money;
            System.out.println("取款"+money+"成功");
        }else{
            System.out.println("取款"+money+"失败");
        }
    }
}

class DrawThread extends Thread{
    Account DrawAccount;
    public DrawThread(Account acc){
        super();
        DrawAccount = acc;
    }

    public void run(){
        try{
            sleep(100);
            DrawAccount.getMoney(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


