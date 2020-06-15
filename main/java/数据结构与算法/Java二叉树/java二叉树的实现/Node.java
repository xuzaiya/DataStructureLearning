package 数据结构与算法.Java二叉树.java二叉树的实现;

//节点类

public class Node {
    private int data; //数据
    private Node left;//左孩子
    private Node right;//右孩子

    public Node(int data){
        this.data = data;

    }

    public void setLChild(Node left){
        this.left = left;
    }

    public void setRChild(Node right){
        this.right = right;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return this.data;
    }

    public Node getLChild(){
        return this.left;
    }

    public Node getRChild(){
        return this.right;
    }
}
