package 数据结构与算法.树.二叉搜索树;


import 数据结构与算法.树.二叉树.Tree;

public class BST {
    public static void main(String[] args) {

        // 测试数据，测试数据现在纸上画好结构，要按层序遍历的顺序输入数组即可
        int[] data = { 11, 8, 19, 5, 10, 16, 21, 3, 6, 9, 18 };
        // 测试插入
        Node tree = null;
        Node tree4 = new Node();
        for (int i = 0; i < data.length; i++) {
            // tree = insert(tree, data[i]);
            // tree = insert2(tree, data[i]);
            // tree = insert3(tree, data[i]);
            insert3(tree4, data[i]);
        }
        // 遍历一下，看看是否插对了，关于树的遍历，请查看本博客关于二叉树的遍历
        //Tree.pre(tree);
        System.out.println("**********");
        //Tree.ceng(tree);
        System.out.println("**********");
        // 测试findMin
        System.out.println("最小值：" + findMin(tree).element);
        // 测试findMax
        System.out.println("最大值：" + findMax(tree).element);
        // 测试find
        // int i = 11;
        // int i = 8;
        // int i = 19;
        // int i = 5;
        // int i = 10;
        // int i = 16;
        // int i = 21;
        // int i = 3;
        // int i = 6;
        // int i = 9;
        // int i = 18;
        int i = 7;
        // Node find = find(tree, i);
        // Node find = find2(tree, i);
        Node find = find3(tree, i);
        if (find != null)
            System.out.println(find.element);
        else
            System.out.println(find);

        // 测试delete
        // int i = 11;
        // int i = 8;
        // int i = 19;
        // int i = 5;
        // int i = 10;
        // int i = 16;
        // int i = 21;
        // int i = 3;
        // int i = 6;
        // int i = 9;
        // int i = 18;
        // int i = 7;
        // tree = delete(tree, i);
        // 层序遍历，相关代码实现请参考本博客中二叉树的相关操作
        // BinaryTree.ceng(tree);

    }

    // 递归插入
    public static Node insert(Node tree, int element) {
        Node temp = null;
        // 树空的情况下，建树,返回
        if (tree == null) {
            temp = new Node(element);
            return temp;
        }
        temp = tree;
        // 树不空
        // 插入值大于节点值，往右子树插入
        if (element > temp.element)
            temp.right = insert(temp.right, element);
        // 插入值小于节点值，往左子树插入
        if (element < temp.element)
            temp.left = insert(temp.left, element);
        return temp;
    }

    //递归插入
    public static Node insert4(Node tree ,int element){
        Node temp = null;
        if(tree == null){
            temp = new Node(element);
            return temp;
        }
        temp = tree;
        if(element>temp.element){
            temp.right = insert(temp.right,element);

        }

        if(element<temp.element){
            temp.left = insert(temp.left,element);
        }
        return temp;
    }






    // 递归插入 精简版
    public static Node insert2(Node tree, int des) {
        if (tree == null)
            return new Node(des);
        if (des > tree.element)
            tree.right = insert2(tree.right, des);
        if (des < tree.element)
            tree.left = insert2(tree.left, des);
        return tree;
    }


    // 非递归插入，返回值
    public static Node insert3(Node tree, int des) {
        if (tree == null)
            return new Node(des);
        Node temp = tree;
        while (true) {
            if (des < temp.element) {
                if (temp.left == null) {
                    temp.left = new Node(des);
                    return tree;
                }
                temp = temp.left;
            } else if (des > temp.element) {
                if (temp.right == null) {
                    temp.right = new Node(des);
                    return tree;
                }
                temp = temp.right;
            }
        }
    }

    //非递归插入
    public static Node insert5(Node tree,int des){
        if (tree == null)return new Node(des);

        Node temp = tree;
        while(true){
            if (des<temp.element){
                if(temp.left == null){
                    temp.left = new Node(des);
                    return tree;
                }
                temp = temp.left;
            }else if(des>temp.element){
                if(temp.right == null){
                    temp.right = new Node(des);
                    return tree;
                }
                temp = temp.right;
            }
        }

    }









    public static Node findMin(Node tree) {
        if (tree == null)
            return null;
        Node temp = tree;
        // 根节点的左子树不为空，就一直往左走，走到根节点的左子树为空退出
        while (temp.left != null)
            temp = temp.left;
        // 根节点的左子树为空，返回根节点的值
        return temp;
    }


    public static Node findMax(Node tree) {
        if (tree == null)
            return null;
        Node temp = tree;
        // 根节点的右子树不为空，就一直往右走，走到根节点的右子树为空退出
        while (temp.right != null)
            temp = temp.right;
        // 根节点的右子树为空，返回根节点的值
        return temp;
    }


    // 递归查找
    public static Node find2(Node tree, int des) {
        // 递归头
        if (tree == null)
            return null;
        Node temp = tree;
        // des大于根节点的处理方式
        if (des > temp.element)
            return find2(temp.right, des);
            // des小于根节点的处理方式
        else if (des < temp.element)
            return find2(temp.left, des);
            // des等于根节点的处理方式
        else
            return temp;
    }



    // 非递归查找
    public static Node find(Node tree, int des) {
        // 递归头
        if (tree == null)
            return null;
        Node temp = tree;
        // 所有的退出情况都在while内部讨论，所以while不需要设立退出条件
        while (true) {
            // des大于根节点的处理方式
            if (des > temp.element) {
                // 根节点的右节点为空，函数退出没找到
                if (temp.right == null)
                    return null;
                // 根节点的右节点不为空，继续往右找下一个
                temp = temp.right;
                // des小于根节点的处理方式
            } else if (des < temp.element) {
                // 根节点的左节点为空，函数退出没找到
                if (temp.left == null)
                    return null;
                // 根节点的左节点为空，继续往右找下一个
                temp = temp.left;
                // des等于根节点的处理方式
            } else
                return temp;
        }
    }



    // 非递归查找精简版
    public static Node find3(Node tree, int des) {
        if (tree == null)
            return null;
        while (tree != null) {
            if (des < tree.element)
                tree = tree.left;
            else if (des > tree.element)
                tree = tree.right;
                // 找到了，返回tree
            else
                return tree;
        }
        // 未找到
        return tree;
    }


    // 递归删除
    public static Node delete(Node tree, int des) {
        // 临时节点
        Node temp = null;
        // 根节点为空，提示未找到，返回原来的树
        if (tree == null)
            System.out.println("not found");
            // 如果des小于根节点，递归删除左子树
        else if (des < tree.element)
            tree.left = delete(tree.left, des);
            // 如果des大于根节点，递归删除右子树
        else if (des > tree.element)
            tree.right = delete(tree.right, des);
            // 如果des==根节点，删除根节点，分一下几种情况讨论
        else {
            // 根节点有左右儿子，将右子树的最小节点的值复制上来，删除右子树的最小节点
            if (tree.left != null && tree.right != null) {
                temp = findMin(tree.right);
                tree.element = temp.element;
                tree.right = delete(tree.right, temp.element);
                // 根节点只有一个儿子或者没有儿子
            } else {
                temp = tree;
                // 只有右儿子或者没有儿子
                if (tree.left == null)
                    tree = tree.right;
                    // 只有右儿子或者没有儿子
                else if (tree.right == null)
                    tree = tree.left;
                temp = null;
            }
        }

        return tree;
    }





}
