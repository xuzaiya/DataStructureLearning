package 数据结构与算法.递归.java实现字符串的全排列;





import java.util.ArrayList;
import java.util.TreeSet;

/*
字符串的全排列：
举例： 输入一个字符串，abc   输出所有a,b,c 所能排列出来的字符串abc，acb，bac，bca，cab，cba
 */
public class Solution {
    public ArrayList<String> Permutation(String str){
        ArrayList<String> res = new ArrayList<String>();
        if (str == null || str.length() == 0){
            return res;
        }
        char[] charArray = str.toCharArray();
        //输出按照输入字典顺序
        TreeSet<String>tempRes = new TreeSet<>();
        permutationCore(charArray,tempRes,0);
        res.addAll(tempRes);
        return res;

    }

    private void permutationCore(char[]charArray,TreeSet<String> tempRes,int loc){
        if (charArray == null || charArray.length == 0 || loc<0 || loc>=charArray.length){
            return ;
        }
        if (loc == charArray.length-1){
            tempRes.add(String.valueOf(charArray));// 递归的出口

        }else{
            for (int i=loc;i<charArray.length;i++){
                swap(charArray,i,loc); // 将第一个字符和后面的交换
                permutationCore(charArray,tempRes,loc+1);// 对后面的所有字符尽心全排列
                swap(charArray,i,loc); //再将之前交换的字符交换回来，以便第一个字符再与其他字符交换
            }
        }
    }

    private void swap(char[] charArray,int i,int j){
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> list = solution.Permutation("abc");
        System.out.println(list.toString());
    }

}
