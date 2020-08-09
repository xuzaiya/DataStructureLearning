package 旭仔专用测试Demo;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int e_num = scan.nextInt();//测试数
		while(e_num>0){
			int length = scan.nextInt();
			Integer[] array = new Integer[length];
			for(int i=0;i<length;i++){
				array[i] = scan.nextInt();
			}
			Integer[] target = array.clone();
			Arrays.sort(target,new Comparator<Integer>(){
				@Override
				public int compare(Integer o1,Integer o2){
					if(o1>o2){
						return 1;
					}
					if(o1<o2){
						return -1;
					}
					return 0;
				}
			});
			HashMap<Integer,Integer> map = new HashMap<>();
			for(int i=0;i<length;i++){
				map.put(target[i],i);
			}
			boolean[] flag = new boolean[length];
			Arrays.fill(flag, false);
			int result = 0;
			for(int i=0;i<length;i ++){
				while(flag[i]==false){
					if(map.get(array[i])==i){
						flag[i]=true;
						break;
					}
					int temp = array[i];
					//	System.out.println(temp);
					array[i] = array[map.get(array[i])];
					array[map.get(temp)] = temp;
					result++;
					//	System.out.println(result);
				}
			}
			System.out.println(result);
			e_num --;
		}
	}
}