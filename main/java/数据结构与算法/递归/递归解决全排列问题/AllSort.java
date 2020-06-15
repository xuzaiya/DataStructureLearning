package 数据结构与算法.递归.递归解决全排列问题;

public class AllSort {
    public static void perm(int[] list,int k,int m){
        if (k == m){
            for (int i=0;i<=m;i++){
                System.out.print(list[i]);
            }
            System.out.println();
        }else{
            for (int i=k;i<=m;i++){
                swap(list,k,i);
                perm(list,k+1,m);
                swap(list,k,i);
            }
        }
    }
    public static void swap(int[]list,int a,int b){
        int temp;
        temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    public static void main(String[] args) {
        int[] list = new int[5];
        for (int i=0;i<list.length;i++){
            list[i] = i+1;
        }
        perm(list,0,list.length-1);
    }
}
