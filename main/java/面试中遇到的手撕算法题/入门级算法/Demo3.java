package 面试中遇到的手撕算法题.入门级算法;


import net.sf.json.util.JSONUtils;
import 面试中遇到的手撕算法题.Node;

/**
 * @author xuzaiya
 * @2020/7/2 9:53
 * 文件说明:二叉树的遍历
 * 前序遍历
 * 后序遍历
 * 中序遍历
 * 层序遍历
 */
public class Demo3 {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6,7,10,13};
        Node tree = creatTree(arr, 0);
        pre(tree);
        //mid(tree);

    }


    //创建二叉树
    public static Node creatTree(int[]data, int i){
        if(i>=data.length||data[i] == -1){
            return null;
        }
        Node  temp= new Node(data[i]);
        temp.left = creatTree(data,i*2+1);
        temp.right = creatTree(data,i*2+2);
        return temp;

    }

    //前序遍历
    public static void pre(Node root){
        if (root == null)return ;
        System.out.println(root.val);
        pre(root.left);
        pre(root.right);
    }

    //中序遍历
    public static void mid(Node root){
        if (root == null)return ;
        mid(root.left);
        System.out.println(root.val);
        mid(root.right);
    }

    //后序遍历
    public static void last(Node root){
        if(root == null)return ;
        last(root.left);
        last(root.right);
        System.out.println(root.val);
    }


}
