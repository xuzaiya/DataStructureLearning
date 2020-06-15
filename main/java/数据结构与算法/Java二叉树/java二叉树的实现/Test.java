package 数据结构与算法.Java二叉树.java二叉树的实现;

public class Test {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,5,6,7,8,9,10,12};
        Tree tree = new Tree();
        tree.root = tree.CreateBTree(array);

        tree.prevOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);



    }
}
