package 数据结构与算法.树.平衡二叉树;



public class AVLTree {
    public static void main(String[] args) {


    }


    //递归判断一个二叉树是不是平衡二叉树
    public boolean isBalanced(Node root){
        return dfsHeight(root)!= Integer.MAX_VALUE;
    }

    public int dfsHeight(Node root){
        if(root == null)return 0;
        int leftHeight = dfsHeight(root.left);
        //左子树不平衡
        if(leftHeight == Integer.MAX_VALUE)return Integer.MAX_VALUE;
        int rightHeight = dfsHeight(root.right);
        //右子树不平衡
        if(rightHeight == Integer.MAX_VALUE) return Integer.MAX_VALUE;

        if(Math.abs(leftHeight-rightHeight) >1)return Integer.MAX_VALUE;
        return Math.max(leftHeight,rightHeight)+1;
    }
}
