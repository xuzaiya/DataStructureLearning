package 面试中遇到的手撕算法题.入门级算法;

/**
 * @author xuzaiya
 * @2020/7/2 9:54
 * 文件说明:NXN正向旋转90度
 */
public class Demo4 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,},{5,6,7},{8,9,10}};
        rotate(matrix);
        for (int i =0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }
    public static void rotate(int[][]matrix){

        int n = matrix.length;
        //先以对角线左上-右下为轴记性翻转
        for (int i=0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        //在每一行的中点进行翻转
        int mid = n>>1;
        for(int i =0;i<n;i++){
            for(int j = 0;j<mid;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }


}
