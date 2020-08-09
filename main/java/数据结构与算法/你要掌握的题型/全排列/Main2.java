package 数据结构与算法.你要掌握的题型.全排列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author xuzaiya
 * @2020/8/1 19:41
 * 文件说明:
 */
public class Main2 {
    public static Set<String> result = new HashSet<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] permutation = permutation(str);
        Stream.of(permutation).forEach(System.out::println);

    }



    public static String[] permutation(String s) {
        if(s == null) return new String[]{};
        boolean[] visited = new boolean[s.length()];
        process(s, "", visited);
        //return result.toArray(new String[result.size()]);
        Object[] ob = result.stream().map(String::valueOf).toArray();
        return Arrays.stream(ob).toArray(String[]::new);
    }


    private static void process (String s ,String letter ,boolean[]visited){
        if(s.length() == letter.length()){
            result.add(letter);
            return ;
        }
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if(visited[i])continue;
            visited[i] = true;
            process(s,letter+String.valueOf(temp),visited);
            visited[i] = false;
        }
    }

}










