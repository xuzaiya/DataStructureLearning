package 数据结构与算法.树.平衡二叉树.平衡二叉树;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/23 20:27
 * @Description: # 类的描述
 */
public class AVLNode<Integer extends Comparable> {
    public AVLNode<Integer> left; //左节点
    public AVLNode<Integer> right; //右节点
    public Integer data;
    public int height ; //当前节点的高度



    public AVLNode(Integer data) {
        this(null,null,data);
    }

    public AVLNode(AVLNode<Integer>left,AVLNode<Integer>right,Integer data){
        this(left,right,data,0);
    }

    public AVLNode(AVLNode<Integer> left, AVLNode<Integer> right, Integer data, int height){
        this.left = left;
        this.right = right;
        this.data = data;
        this.height = height;
    }

}
