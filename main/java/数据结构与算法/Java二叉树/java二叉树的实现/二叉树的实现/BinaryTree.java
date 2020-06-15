package 数据结构与算法.Java二叉树.java二叉树的实现.二叉树的实现;


public class BinaryTree {
    //根节点
    private TreeNode root;
    public TreeNode getRoot(){
        return root;
    }

    //插入操作
    public void insert(int data){
        TreeNode newNode = new TreeNode(data);
        if (root == null){
            root = newNode;
            root.setLeftTreeNode(null);
            root.setRightTreeNode(null);
        }else{
            TreeNode currentNode = root;
            TreeNode parentNode ;
            while(true){
                parentNode = currentNode;
                //往右放
                if (newNode.getData()>currentNode.getData()){
                    currentNode = currentNode.getRightTreeNode();
                    if (currentNode == null){
                        parentNode.setRightTreeNode(newNode);
                        return ;
                    }
                }else{
                    //往左放
                    currentNode = currentNode.getLeftTreeNode();
                    if (currentNode == null){
                        parentNode.setLeftTreeNode(newNode);
                    }
                }
            }
        }
    }


    //查找
    public TreeNode find(int key){
        TreeNode currentNode = root;
        if (currentNode!=null){
            while (currentNode.getData()!=key){
                if (currentNode.getData()>key){
                    currentNode = currentNode.getLeftTreeNode();
                }else{
                    currentNode = currentNode.getRightTreeNode();
                }
            }

            if (currentNode == null){
                return null;
            }
            if (currentNode.isDelete()){
                return null;

            }else{
                return currentNode;
            }

        }else{
            return null;
        }
    }

    //中序遍历
    public void inOrder(TreeNode treeNode){
        if (treeNode !=null && treeNode.isDelete() == false){
            inOrder(treeNode.getLeftTreeNode());
            System.out.println("--"+treeNode.getData());
            inOrder(treeNode.getRightTreeNode());
        }
    }

}
