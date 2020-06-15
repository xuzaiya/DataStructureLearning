package 旭仔专用测试Demo;

import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int r = scan.nextInt();
        int c = scan.nextInt();

        int[][] array = new int[n][m];
        int up = 0;
        int down = array.length-1;
        int left = 0;
        int right = array[0].length-1;

        int count = 1;

        while(true){
            for (int col = left;col<=right;col++){
                array[up][col] = count++;
            }
            up++;
            if(up>down)break;
            for(int row =up;row<=down;row++){
                array[row][right] = count++;
            }
            right--;
            if(left>right)break;
            for(int col = right;col>=left;col--){
                array[down][col]=count++;
            }
            down--;
            if(up>down)break;
            for(int row = down;row>=up;row--){
                array[row][left] = count++;
            }
            left++;
            if(left>right)break;

        }




        System.out.println(array[r-1][c-1]);

    }
}
