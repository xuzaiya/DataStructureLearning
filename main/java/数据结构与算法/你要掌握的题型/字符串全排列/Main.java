package 数据结构与算法.你要掌握的题型.字符串全排列;

/**
 * @author xuzaiya
 * @2020/8/8 13:55
 * 文件说明:利用递归算法，类似二叉树的先序遍历，最重要的不同是要解决回朔问题，
 * 按照常规的递归算法a->b->c,输出abc后，回朔到b此时的缓存字符串应当做删除操作，将c删掉，否则继续append的话会有形如abccb的错误。
 */
public class Main {
    public static void main(String[] args) {
        String s = "abcd";
        StringBuilder currentString = new StringBuilder();
        funllPermutation(s,currentString);
    }

    private static void funllPermutation(String s,StringBuilder currentString){
        if (s.isEmpty()){
            System.out.println(currentString);
        }
        for (int i= 0;i<s.length();i++){
            char ch = s.charAt(i);
            currentString.append(ch);
            String newString = s.replaceAll(String.valueOf(ch),"");//删除字母
            funllPermutation(newString,currentString);
            currentString.delete(currentString.length()-1,currentString.length());//解决回溯问题

        }
    }
}
