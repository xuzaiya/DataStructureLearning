package 数据结构与算法.Java二叉树.java二叉树的实现.二叉树的实现;

public class TreeNode {
    private TreeNode leftTreeNode;
    private TreeNode rightTreeNode;
    private int data;
    private boolean isDelete;


    public TreeNode getLeftTreeNode() {
        return leftTreeNode;
    }

    public void setLeftTreeNode(TreeNode leftTreeNode) {
        this.leftTreeNode = leftTreeNode;
    }

    public TreeNode getRightTreeNode() {
        return rightTreeNode;
    }

    public void setRightTreeNode(TreeNode rightTreeNode) {
        this.rightTreeNode = rightTreeNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isDelete(){
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public TreeNode(){
        super();
    }

    public TreeNode(int data){
        this(null,null,data,false);
    }

    public TreeNode(TreeNode leftTreeNode,TreeNode rightTreeNode,int data,boolean isDelete){
        super();
        this.leftTreeNode = leftTreeNode;
        this.rightTreeNode  = rightTreeNode;
        this.data = data;
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Node{" +
                "leftTreeNode=" + leftTreeNode +
                ", rightTreeNode=" + rightTreeNode +
                ", data=" + data +
                ", isDelete=" + isDelete +
                '}';
    }
}
