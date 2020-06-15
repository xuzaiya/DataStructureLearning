package 数据结构与算法.Java二叉树.java二叉树的实现.二叉树的实现;

public class Test {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        //添加数据测试
        tree.insert(10);
        tree.insert(40);
        tree.insert(20);
        tree.insert(3);
        tree.insert(49);
        tree.insert(13);
        tree.insert(123);


        tree.inOrder(tree.getRoot());
    }
}
