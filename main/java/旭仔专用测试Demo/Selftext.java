package 旭仔专用测试Demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Selftext {
        public static void main(String[] args) {
                Map<Integer,Integer> aList=new HashMap<>();
                Scanner scanner = new Scanner(System.in);
                int n  =scanner.nextInt();
                int [] value = new int[n];
                for(int i=0;i<n;i++){
                        value[i] = scanner.nextInt();
                }

                for (int i = 0; i < value.length; i++) {

                        aList.put(value[i], i);
                }
                Arrays.sort(value);
                int index=aList.size(),count=0;
                for (int i = 0; i < aList.size()-1; i++) {
                        if (aList.get(value[i])>aList.get(value[i+1])) {
                                aList.put(value[i+1], index++);
                                count++;
                        }
                }
                System.out.println(count);
        }
}
