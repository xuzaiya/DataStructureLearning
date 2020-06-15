package 旭仔专用测试Demo;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[3];
        for (int i=0;i<array.length;i++){
            array[i] = scan.nextInt();
        }
        int count = 0;
        while(n>0){
            int i=0;
            for( ;i<array.length;i++){
                if(n%array[i] == 0){
                    break;
                }

            }
            if(i == 3){
                count++;
            }

            n--;
        }
        System.out.println(count);


    }
}
