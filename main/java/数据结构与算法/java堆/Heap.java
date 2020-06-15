package 数据结构与算法.java堆;

public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int mx){
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty(){
        return (currentSize==0)? true:false;

    }

    public boolean isFull(){
        return (currentSize == maxSize)?true:false;
    }

    public boolean insert(int key){
        if (isFull()){
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;

    }


    //向上调整
    public void trickleUp(int index){
        int parent =(index-1)/2; //父亲的节点索引
        Node bottom = heapArray[index]; //将新加的尾节点存在bottom中
        while(index>0&&heapArray[parent].getKey()<bottom.getKey()){
            heapArray[index] = heapArray[parent];
            index = parent;
            parent=(parent-1)/2;
        }
        heapArray[index] = bottom;
    }

    public Node remove(){
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    //向下调整
    public void trickleDown(int index){
        Node top = heapArray[index];
        int largeChildIndex ;
        while(index<currentSize/2){
            int leftChildIndex = 2*index+1;
            int rightChildIndex = leftChildIndex+1;
            if(rightChildIndex<currentSize&&heapArray[leftChildIndex].getKey()<heapArray[rightChildIndex].getKey()){
                largeChildIndex = rightChildIndex;
            }else{
                largeChildIndex = leftChildIndex;
            }
            if (top.getKey()>=heapArray[largeChildIndex].getKey()){
                break;
            }
            heapArray[index] = heapArray[largeChildIndex];
            index  = largeChildIndex;
        }
        heapArray[index] = top;
    }

    //根据索引改变堆中的某个数据
    public boolean change(int index,int newValue){
        if (index<0||index>=currentSize){
            return false;
        }
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if(oldValue<newValue){
            trickleUp(index);
        }else{
            trickleDown(index);
        }
        return  true;
    }

    //展示
    public void displayHeap(){
        System.out.println("heapArray(array format):");
        for (int i=0;i<currentSize;i++){
            if (heapArray[i]!=null){
                System.out.print(heapArray[i].getKey()+" ");
            }else{
                System.out.print("--java");
            }
        }
    }



    class Node{
        private int iData;
        public Node(int key){
            iData = key;
        }

        public int getKey(){
            return iData;
        }

        public  void setKey(int key ){
            this.iData = key;
        }
    }




}


