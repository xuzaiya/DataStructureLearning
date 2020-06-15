package 数据结构与算法.Java二叉树.java二叉树的实现;

public class Tree {
    public Node root; //根节点
    public static int count;

    public Node CreateBTree(int[] a){
        Node root = null;
        if (count<a.length){
            root = new Node(a[count]);
            count++;
            root.setLChild(CreateBTree(a));
            count++;
            root.setRChild(CreateBTree(a));
        }
        return root;
    }






    //先序遍历
    public void prevOrder(Node root){
        if (root == null){
            return ;
        }
        System.out.print(root.getData()+ " ,");
        prevOrder(root.getLChild());
        prevOrder(root.getRChild());
    }

    // 中序遍历
    public void inOrder(Node root){
        if (root == null){
            return ;
        }
        inOrder(root.getLChild());
        System.out.print(root.getData()+" , ");
        inOrder(root.getRChild());
    }

    //后序遍历
    public void postOrder(Node root){
        if (root == null){
            return ;
        }
        postOrder(root.getLChild());
        postOrder(root.getRChild());
        System.out.print(root.getData()+" , ");
    }


    //获得高度
    public int getHeight(){
        Node cur = this.root;
        int height = 0;
        while(cur!=null){
            cur = cur.getLChild();
            height++;
        }
        return height;
    }

    //获得叶子节点
    public int getLeaf(Node root){
        if (root == null){
            return 0;
        }else if(root.getLChild() == null && root.getLChild()== null){
            System.out.println("Leaf:"+root.getData());
            return 1;

        }else{
            return getLeaf(root.getLChild())+getLeaf(root.getRChild());
        }
    }

    // 获得第k层的节点
    public int getNodeKnum(Node root , int k){
        if (k== 1){
            if (root == null ){
                return 0;
            }
            System.out.println(" k Node:"+root.getData());
            return 1;
        }
        return getNodeKnum(root.getLChild(),k-1)+getNodeKnum(root.getRChild(),k-1);
    }

    //找到某个节点
    public Node findNode(Node root , int x){
        if (root == null){
            return null;
        }else if(root.getData() == x){
            return root;
        }
        Node leftNode = findNode(root.getLChild(),x);
        if (null!=leftNode)
            return leftNode;
        Node rightNode = findNode(root.getRChild(),x);
        if (null!=rightNode)
            return rightNode;
        return null;
    }

    //返回某个节点的父节点
    public Node getParent(Node root,int x){
        if (root == null){
            return null;
        }
        Node childL = root.getLChild();
        Node childR = root.getRChild();
        if (childL!=null && childL.getData() == x)
            return root;
        if (childR!=null&&childR.getData() == x)
            return root;
        Node parentL = getParent(root.getLChild(),x);
        if (parentL!=null){
            return parentL;

        }
        Node parentR = getParent(root.getRChild(),x);
        if (parentR!=null)
            return parentR;
        return null;
    }



}
