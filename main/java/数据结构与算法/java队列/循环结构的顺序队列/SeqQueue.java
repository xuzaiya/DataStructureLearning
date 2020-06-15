package 数据结构与算法.java队列.循环结构的顺序队列;

import 数据结构与算法.java队列.Queue;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/24 11:16
 * @Description: # 类的描述
 */
public class SeqQueue<T> implements Queue<T>, Serializable {

    private static final long serialVersionUID = -1664818681270068094L;
    private static final int  DEFAULT_SIZE = 10;

    private T elementData[];
    private int front,rear;
    private int size;

    public SeqQueue(){
        elementData = (T[])new Object[DEFAULT_SIZE];
        front = rear = 0;
    }

    public SeqQueue(int capacity){
        elementData= (T[]) new Object[capacity];
        front=rear=0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    /*
    * 向队列里面添加元素，成功返回true，否则返回false
    * */
    @Override
    public boolean add(T data) {
        //判断是否满队列
        if(this.front ==  (this.rear+1)%this.elementData.length){
            ensureCapacity(elementData.length*2+1);
        }
        //添加元素
        elementData[this.rear] = data;
        this.rear = (this.rear+1)%elementData.length;
        size++;
        return true;
    }

    /*
    *offer 方法可插入一个元素,这与add 方法不同，
     * 该方法只能通过抛出未经检查的异常使添加元素失败。
     * 而不是出现异常的情况，例如在容量固定（有界）的队列中
     * NullPointerException:data==null时抛出
     * IllegalArgumentException:队满,使用该方法可以使Queue的容量固定
    *
    * */
    @Override
    public boolean offer(T data) {
        if (data == null)throw new NullPointerException("this data can't be null");
        //队列满抛出异常
        if(this.front == (this.rear+1)%this.elementData.length){
            throw new IllegalArgumentException("The capacity of SeqQueue has reached its maximum");
        }
        //添加data
        elementData[this.rear] = data;
        this.rear = (this.rear+1)%elementData.length;
        size++;
        return true;
    }

    /**
     * 返回队头元素,不执行删除操作,若队列为空,返回null
     * @return
     */
    @Override
    public T peek() {
        return elementData[front];
    }

    /**
     * 返回队头元素,不执行删除操作,若队列为空,抛出异常:NoSuchElementException
     * @return
     */
    @Override
    public T element() {

        if(isEmpty()){
            throw new NoSuchElementException("The SeqQueue is empty");
        }
        return peek();
    }

    /**
     * 出队,执行删除操作,返回队头元素,若队列为空,返回null
     * @return
     */
    @Override
    public T poll() {
        T temp = this.elementData[this.front];
        this.front=(this.front+1)%this.elementData.length;
        size--;
        return temp;
    }

    /**
     * 出队,执行删除操作,若队列为空,抛出异常:NoSuchElementException
     * @return
     */
    @Override
    public T remove() {
        if (isEmpty()){
            throw new NoSuchElementException("The SeqQueue is empty");
        }
        return poll();
    }

    @Override
    public void clearQueue() {
        for (int i = this.front;i!=this.rear;i=(i+1)%elementData.length){
            elementData[i] = null;
        }
        this.front = this.rear = 0;
        size = 0;

    }

    /**
     * 扩容的方法
     * @param capacity
     */
    public void ensureCapacity(int capacity){
        //如果需要扩展的容量比现在的数组的容量还小，则无需扩容
        if (capacity<size){
            return ;
        }
        T[]old = elementData;
        elementData = (T[])new Object[capacity];
        int j  = 0;
        for (int i = this.front;i!=this.rear;i=(i+1)%old.length){
            elementData[j++] = old[i];
        }
        this.front = 0 ;
        this.rear = j;
    }


}
