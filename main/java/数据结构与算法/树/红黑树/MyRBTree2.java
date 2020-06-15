package 数据结构与算法.树.红黑树;

public class MyRBTree2<T extends Comparable<T>> {
    private RBNode<T> root;//根节点
    private static final Boolean RED = false;
    private static final Boolean BLACK = true;

    public class RBNode<T extends Comparable<T>>{
        private Boolean color; //节点颜色
        private T key; //数据
        private RBNode parent;
        private RBNode leftChild;
        private RBNode rightChild;

        public RBNode(Boolean color, T key, RBNode<T> parent, RBNode leftChild, RBNode rightChild) {
            this.color = color;
            this.key = key;

            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }


    //获取父亲节点
    public RBNode<T> parentOf(RBNode<T> node){
        return node.parent ==null ? null:node.parent;
    }

    //左旋
    public void leftRonate(RBNode<T> x){
        RBNode<T> y = x.rightChild;
         x.rightChild = y.leftChild;
         if(y.leftChild !=null){
             y.leftChild.parent = x;
         }

        y.parent = x.parent;
         if(x.parent == null){
            this.root = y;
         }else{
             if(x.parent.leftChild == x){
                 x.parent.leftChild = y;
             }else{
                 x.parent.rightChild = y;
             }
         }

         y.leftChild = x;
         x.parent = y;
    }


    //右旋
    public void rightRonate(RBNode<T>y){
        RBNode<T> x = y.leftChild;
        y.leftChild = x.rightChild;
        if(x.rightChild !=null){
            x.rightChild.parent = y;
        }
        x.parent = y.parent;
        if(y.parent !=null){
            if(y.parent.leftChild == y){
                y.parent.leftChild = x;
            }else{
                y.parent.rightChild = x;
            }
        }else{
            this.root = x;
        }

        x.rightChild = y;
        y.parent = x;


    }


    //红黑树的插入操作
    public void insert(T key){
        RBNode<T> node = new RBNode<>(RED,key,null,null,null);
        if (node !=null){
            insert(node);
        }
    }

    public void insert(RBNode<T> node){
        RBNode<T> current = null ; // 表示最后node 的父亲节点
        RBNode<T> x  = this.root;
        while (x!=null){
            current = x;
            int cmp = node.key.compareTo(x.key);
            if(cmp<0){
                x = x.leftChild;
            }else{
                x = x.rightChild;
            }

        }
        node.parent = current;
        if (current!=null){
            int cpm = node.key.compareTo(current.key);
            if(cpm<0){
                current.leftChild = node;
            }else{
                current.rightChild  = node;
            }
        }else{
            this.root = node;
        }

        //利用旋转操作将其修正为一颗红黑树
        insertFixUp(node);

    }

    private void insertFixUp(RBNode<T> node){

    }






}
