package 旭仔专用测试Demo;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str  = scan.nextLine();
        char[] array = str.toCharArray();
        for(int i=0;i< array.length;i++){
            array[i] = (char) (array[i]+3);
        }
        System.out.println(new String(array));
    }
}
