package 旭仔专用测试Demo;

import org.springframework.dao.CleanupFailureDataAccessException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author xuzaiya
 * @2020/8/9 16:58
 * 文件说明:
 */
public class Demo26 {
    public static void main(String[] args) {
        int[][] tasks = {{0,1},{1,2},{1,3},{4,5}};
        int i = maxLevel(3, 1, tasks);
        System.out.println(i);

    }

    public static int maxLevel (int x, int level, int[][] tasks) {
        if(tasks == null || tasks.length<=0)return level;

        int row = tasks.length;
        int maxLevel = level;
        boolean[] temp = new boolean[row];
        for(int i=0;i<x;i++){
            int max = 0;
            int k = 0;
            for(int j=0;j<row;j++){
                if(!temp[j]){
                    if(maxLevel>=tasks[i][0]){
                        max = Math.max(max,tasks[j][1]);
                        k=j;
                    }
                }

            }

            if(max == 0){
                return maxLevel;
            }else{
                maxLevel +=max;
                temp[k] = true;
            }



        }
        return maxLevel;

    }
}
