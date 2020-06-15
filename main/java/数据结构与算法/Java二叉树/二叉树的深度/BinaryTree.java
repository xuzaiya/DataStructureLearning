package 数据结构与算法.Java二叉树.二叉树的深度;

public class BinaryTree {
    Node root;

    public BinaryTree(){
        root = null;
    }
    //为了方便起见，我就直接写个初始化的二叉树，详细的可以见以前的日志
    public void initTree(){

        Node node1 = new Node("a");
        Node node2 = new Node("b");
        Node node3 = new Node("c");
        Node node4 = new Node("d");
        Node node5 = new Node("e");
        root = node1;
        node1.left = node2;
        node2.right = node3;
        node1.right = node4;
        node3.left = node5;
    }
    //求二叉树的深度
    int length(Node root){
        int depth1;
        int depth2;
        if(root == null) return 0;
        //左子树的深度
        depth1 = length(root.right);
        //右子树的深度
        depth2 = length(root.left);
        if(depth1>depth2)
            return depth1+1;
        else
            return depth2+1;
    }
}