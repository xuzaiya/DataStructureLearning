package 数据结构与算法.Java二叉树.二叉树的深度;

/*

下面是是实现二叉树的递归算法的实现，其思想就是，若为空，则其深度为0，否则，其深度等于左子树和右子树的深度的最大值加1
  */
public class TestMatch {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.initTree();
        System.out.println(tree.length(tree.root)); //求二叉树的深度
    }






}
