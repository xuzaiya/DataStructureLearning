package 数据结构与算法.java栈.栈的应用实例;

import 数据结构与算法.java栈.链式栈的设计与实现.LinkedStack;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/24 15:58
 * @Description: # 符号匹配
 */
public class CheckExpression {
    public static String isValid(String expstr){
        //创建栈
        LinkedStack<String> stack = new LinkedStack<>();
        int i = 0 ;
        while(i<expstr.length()){
            char ch = expstr.charAt(i);
            i++;
            switch (ch){
                case '(':stack.push(ch+"");break;
                case ')':
                    if(stack.isEmpty() || !stack.pop().equals("("))
                        return "(";
            }
        }

        //最后检测是不是为空，为空则检测通过
        if(stack.isEmpty()){
            return "check pass!";

        }else{
            return "check exception";
        }
    }

    public static void main(String[] args) {
        String expstr="((5-3)*8-2)";
        System.out.println(expstr+" "+isValid(expstr));

    }
}
