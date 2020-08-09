package 旭仔专用测试Demo.贝壳;

import java.util.Scanner;

/**
 * @author xuzaiya
 * @2020/7/29 13:50
 * 文件说明:
 */
public class Demo3 {
    public static void main(String[] args) {
        prob2();
    }

    public static void prob2(){
        Scanner in = new Scanner(System.in);
        String[] nk=in.nextLine().split(" ");
        int n=Integer.parseInt(nk[0]);
        int k=Integer.parseInt(nk[1]);
        String t=in.nextLine();
        char[] T=t.toCharArray();
        int comLen=0;
        for(int i=0;i<n-1;i++){
            if(T[i]==T[n-1]){
                int curT2=i;
                int curT1=n-1;
                while(curT2>=0){
                    if(T[curT2]==T[curT1]){
                        curT1--;
                        curT2--;
                    }else {
                        break;
                    }
                }
                if(curT2<0) comLen=Math.max(i+1,comLen);
            }
        }
        StringBuilder re=new StringBuilder();
        re.append(t);
        for(int i=1;i<k;i++){
            for(int j=comLen;j<n;j++){
                re.append(T[j]);
            }
        }
        System.out.println(re.toString());
    }
}
