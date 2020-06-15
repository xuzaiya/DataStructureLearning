package 刷题.排序;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test853 {
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[]speed = {2,4,1,1,3};
        carFleet(target,position,speed);

    }

    public static int carFleet(int target,int[]position,int[]speed){

        double [] hour = new double[position.length] ;
        for (int i=1;i<position.length;i++){
            for (int j=0;j<position.length-i;j++){
                if (position[j+1]<position[j]){
                    int temp = position[j];
                    position[j]  = position[j+1];
                    position[j+1] = temp;
                    int temp1 = speed[j];
                    speed[j] = speed[j+1];
                    speed[j+1] = temp1;


                }

            }

        }
        for (int i=0;i<position.length;i++){
            hour[i] = 1.0 *(target-position[i])/speed[i];
        }

        int nums= 0;

        boolean flag = false;
        for (int i=position.length-1;i>=0;i--){
            if (i==position.length-1){
                nums++;
                continue;
            }
            if (hour[i]<=hour[i+1]){
                flag = true;
                continue;
            }else{
                if (flag == true){
                    int j=i;
                    for (;j<hour.length-1;j++){
                        if (hour[j] < hour[j+1]){
                            nums++;break;

                        }
                    }
                    if (j == hour.length){
                        nums++;
                    }
                }else{
                    nums++;
                }
            }
        }
        System.out.println(nums);
        return nums;

    }
}
