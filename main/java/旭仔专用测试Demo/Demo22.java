package 旭仔专用测试Demo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author xuzaiya
 * @2020/8/8 15:34
 * 文件说明:
 */
public class Demo22 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] strArray = new String[n];
        for(int i =0;i<n;i++){
            strArray[i] = scan.nextLine();
        }
        HashMap<String , Integer> map = new HashMap<>();
        for(String str: strArray){
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }else{
                map.put(str,1);
            }
        }
        int count = 0;
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            if((1.0*map.get(next)/n)>=0.01){
                count++;
            }
        }
        System.out.println(count);


    }
}
