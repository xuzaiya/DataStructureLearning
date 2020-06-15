package 数据结构与算法.树.二叉树;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    //创建二叉树
    public static Node creatTree(int[]data,int i){
        if(i>=data.length||data[i] == -1){
            return null;
        }
        Node  temp= new Node(data[i]);
        temp.left = creatTree(data,i*2+1);
        temp.right = creatTree(data,i*2+2);
        return temp;

    }

    //创建二叉树
    public static Node createTree(int[]data,int i){
        if(i>=data.length || data[i] == -1){
            return null;
        }
        Node temp = new Node(data[i]);
        temp.left = createTree(data,i*2+1);
        temp.right = createTree(data,i*2+2);
        return temp;
    }


    //创建二叉树
    public static Node createTree2(int[]data,int i){
        if(i>=data.length||data[i] == -1){
            return null;
        }
        Node temp = new Node(data[i]);
        temp.left = createTree2(data,i*2+1);
        temp.right = createTree2(data,i*2+2);
        return  temp;

    }












    //二叉树的前序遍历递归
    public static void pre(Node temp){
        if(temp == null)return ;
        System.out.print(temp.element+"  ");
        pre(temp.left);
        pre(temp.right);
    }

    //二叉树的中序遍历递归
    public static void mid(Node temp){
        if(temp == null)return ;
        mid(temp.left);
        System.out.print(temp.element+"  ");
        mid(temp.right);
    }

    //二叉树的后序遍历递归
    public static void last(Node temp){
        if(temp == null)return ;
        last(temp.left);
        last(temp.right);
        System.out.print(temp.element+"  ");
    }

    //pre1前序遍历非递归
    public static void pre4(Node temp){
        Stack<Node> stack = new Stack<>();
        while(temp!=null || !stack.isEmpty()){
            while(temp!=null){
                stack.push(temp);
                System.out.print(temp.element+" ");
                temp = temp.left;
            }
            if(!stack.isEmpty()){
                temp = stack.pop().right;
            }
        }
    }

   //pre1前序遍历非递归
    public static void pre5(Node temp){
        Stack<Node> stack = new Stack<>();
        while(temp!=null || !stack.isEmpty()){
            while(temp!=null){
                stack.push(temp);
                System.out.print(temp.element+" ");
                temp = temp.left;
            }
            if (!stack.isEmpty()){
                temp = stack.pop().right;
            }
        }
    }

    //mid1中序遍历非递归
    public static void mid1(Node temp){
        Stack<Node> stack = new Stack<>();
        while(temp!=null || !stack.isEmpty()){
            while(temp!=null){
                stack.push(temp);
                temp  = temp.left;
            }
            if(!stack.isEmpty()){
                temp = stack.pop();
                System.out.print(temp.element+"  ");
                temp = temp.right;
            }
        }
    }

    //last1后序遍历非递归
    public static void last1(Node temp){
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        while(temp!=null||!stack.isEmpty()){
            while(temp!=null){
                stack.push(temp);
                stack2.push(temp);
                temp = temp.right;
            }
            if(!stack.isEmpty()){
                temp = stack.pop().left;
            }
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().element+"  ");
        }
    }

    //层序遍历
    public static void ceng(Node temp){
        if(temp == null)return ;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(temp);
        while(!queue.isEmpty()){
            temp  = queue.poll();
            System.out.print(temp.element+"  ");
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }

    }

    //层序遍历
    public static void ceng2(Node temp){
        if (temp == null)return ;
        Queue<Node>queue = new ArrayDeque<>();
        queue.offer(temp);
        while(!queue.isEmpty()){
            temp = queue.poll();
            System.out.print(temp.element+" ");
            if (temp.left!=null){
                queue.offer(temp.left);
            }
            if (temp.right!=null){
                queue.offer(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6,7,-1,-1,10,-1,-1,13};
        Node tree = creatTree(arr, 0);

        pre(tree);
        System.out.println();
        System.out.println();
        System.out.println("中序遍历");
        mid(tree);
        System.out.println();
        mid1(tree);
        System.out.println();
        last(tree);
        System.out.println();
        last1(tree);
        System.out.println();
        ceng(tree);


    }
}
