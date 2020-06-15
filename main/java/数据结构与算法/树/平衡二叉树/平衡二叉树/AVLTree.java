package 数据结构与算法.树.平衡二叉树.平衡二叉树;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/23 20:32
 * @Description: # 类的描述
 */
public class AVLTree {
    /*
    * 计算当前节点的深度
    * */
    private int height(AVLNode<Integer> subtree){
        if (subtree == null){
            return 0;
        }else{
            int l = height(subtree.left);
            int r = height(subtree.right);
            return Math.max(l,r)+1;
        }
    }


    /*
    * 左左单旋转LL  w变为x的根结点, x变为w的右子树   右旋
    *
    *       p                   p
     *       /                   /
     *      y                   x
     *     / \                 / \
     *    x  ry   ----->      lx  y
     *   / \                     / \
     * lx  rx                   rx ry
    *
    *
    * */
    private AVLNode<Integer> singleRotateLeft(AVLNode<Integer> x){

        //右旋


        //把w旋转成为根节点
        AVLNode<Integer> w = x.left;
        //同时w的右子树变为x的左子树
        x.left = w.right;
        //将x变为w 的右子树
        w.right = x;
        //重新计算x/w的高度
        x.height = Math.max(height(x.left),height(x.right))+1;
        w.height = Math.max(height(w.left),height(w.right))+1;
        return w;//返回新的根节点
    }

    /*
    * 右右单旋转RR  x变为w的根结点, w变为x的左子树   左旋
    *
    *  *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
    *
    *
    *
    *
    * */
    private AVLNode<Integer> singleRotateRight(AVLNode<Integer> w){



        //把x旋转成为根节点
        AVLNode<Integer> x = w.right;
        //同时x的左子树变成w 的右子树
        w.right = x.left;
        //将w变成x 的左子树
        x.left = w;

        //重新结算x/w的高度
        w.height=Math.max(height(w.left),height(w.right))+1;
        x.height=Math.max(height(x.left),w.height)+1;

        //返回新的根结点
        return x;

    }

    /*
    * 左右旋转LR旋转    x根，w y节点， 把y变成根节点
    * */
    private AVLNode<Integer> doubleRotateWithLeft(AVLNode<Integer> x){
        //w先进行RR旋转
        x.left = singleRotateRight(x.left);
        //在进行x 的L旋转
        return singleRotateLeft(x);
    }


    /*
    * 右左旋转RL旋转
    * */
    private AVLNode<Integer> doubleRotatewithRight(AVLNode<Integer> x){
        //先进行LL旋转
        x.right = singleRotateLeft(x.right);
        //在进行RR旋转
        return singleRotateRight(x);
    }


    /*
    * 平衡二叉树的插入操作
    * */
    private AVLNode<Integer> insert(AVLNode<Integer> root,Integer data){
        if (root==null){
            root = new AVLNode<Integer>(data);
        }else if(data.compareTo(root.data)<0){
            //向左子树寻找插入位置
            root.left = insert(root.left,data);
            //插入后计算子树的高度，等于2则需要重新恢复平衡，由于是左边插入，左子树的高度肯定大于等于右子树的高度
            if(height(root.left)-height(root.left) == 2){
                //判断data 是插入点的左孩子还是右孩子
                if(data.compareTo(root.left.data)<0){
                    //进行LL旋转
                    root = singleRotateLeft(root);
                }else{
                    //进行左右旋转
                    root= doubleRotateWithLeft(root);
                }
            }

        }else if(data.compareTo(root.data)>0){
            //向右子树寻找插入位置
            root.right = insert(root,data);
            if(height(root.right)-height(root.left)==2){
                if (data.compareTo(root.right.data)<0){
                    //进行右左旋转
                    root=doubleRotatewithRight(root);
                }else {
                    root=singleRotateRight(root);
                }
            }

        }
        //重新计算各个节点的高度
        root.height = Math.max(height(root.left),height(root.right))+1;
        return root;

    }


    /*
    * 平衡二叉树的删除操作
    *
    * */
    private AVLNode<Integer> remove(Integer data,AVLNode<Integer> p){

        if(p ==null)
            return null;

        int result=data.compareTo(p.data);

        //从左子树查找需要删除的元素
        if(result<0){
            p.left=remove(data,p.left);

            //检测是否平衡
            if(height(p.right)-height(p.left)==2){
                AVLNode<Integer> currentNode=p.right;
                //判断需要那种旋转
                if(height(currentNode.left)>height(currentNode.right)){
                    //LL
                    p=singleRotateLeft(p);
                }else{
                    //LR
                    p=doubleRotateWithLeft(p);
                }
            }

        }
        //从右子树查找需要删除的元素
        else if(result>0){
            p.right=remove(data,p.right);
            //检测是否平衡
            if(height(p.left)-height(p.right)==2){
                AVLNode<Integer> currentNode=p.left;
                //判断需要那种旋转
                if(height(currentNode.right)>height(currentNode.left)){
                    //RR
                    p=singleRotateRight(p);
                }else{
                    //RL
                    p=doubleRotatewithRight(p);
                }
            }
        }
        //已找到需要删除的元素,并且要删除的结点拥有两个子节点
        else if(p.right!=null&&p.left!=null){

            //寻找替换结点
            p.data=findMin(p.right).data;

            //移除用于替换的结点
            p.right = remove( p.data, p.right );
        }
        else {
            //只有一个孩子结点或者只是叶子结点的情况
            p=(p.left!=null)? p.left:p.right;
        }

        //更新高度值
        if(p!=null)
            p.height = Math.max( height( p.left ), height( p.right ) ) + 1;
        return p;
    }


    /**
     * 查找最小值结点
     * @param p
     * @return
     */
    private AVLNode<Integer> findMin(AVLNode<Integer> p){

        if (p==null)//结束条件
            return null;
        else if (p.left==null)//如果没有左结点,那么t就是最小的
            return p;
        return findMin(p.left);
    }


    /**
     * 查找最大值结点
     * @param p
     * @return
     */
    private AVLNode<Integer> findMax(AVLNode<Integer> p){
        if (p==null)//结束条件
            return null;
        else if (p.right==null)
            return p;
        return findMax(p.right);
    }






}
