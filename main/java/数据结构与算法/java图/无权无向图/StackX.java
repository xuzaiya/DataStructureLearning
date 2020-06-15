package 数据结构与算法.java图.无权无向图;
/*
实现深度优先搜索DFS的栈
 */
public class StackX {
    private final int SIZE=20;
    private int[] st;
    private int top;

    public StackX(){
        st = new int[SIZE];
        top=-1;
    }

    public void push(int data){
        st[++top] = data;


    }

    public int pop(){
        return st[top--];
    }

    public int peek(){
        return st[top];
    }

    public boolean isEmpty(){
        return (top== -1);
    }
}
