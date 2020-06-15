package 刷题.排序;

import java.util.* ;

public class Test1030 {
    public static void main(String[] args) {
        int[][] result = allCellsDistOrder(1,2,0,0);
        System.out.println(result.toString());

    }

    public static int[][] allCellsDistOrder(int R,int C ,int r0,int c0){
        //1.先把距离坐标计算好，距离做key，坐标的数组做value
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int i=0;i<R;i++){
            for (int j=0;j<C;j++){
                int distance = Math.abs(i-r0)+Math.abs(j-c0);
                if (map.containsKey(distance)){
                    ArrayList<int[]> list = map.get(distance);
                    list.add(new int[]{i,j});
                }else{
                    ArrayList<int[]> arrayList=new ArrayList<>();
                    arrayList.add(new int[]{i,j});
                    map.put(distance,arrayList);
                }
            }
        }

        //对map 的key进行排序
        Set<Integer> set = map.keySet();
        set.stream().sorted(Comparator.reverseOrder());
        System.out.println(set.toString());

        //3.取出自己想要的数据结果
        int[][] result = new int[R*C][2];
        Iterator<Integer> it = set.iterator();
       while(it.hasNext()){
           if(map.containsKey(it.next())){
               ArrayList<int[]> arr = map.get(it.next());
               for (int i=0 ;i<arr.size();i++){
                   result[i][0] = arr.get(i)[0];
                   result[i][1] = arr.get(i)[1];
               }

           }
       }
       return result;

    }
}
