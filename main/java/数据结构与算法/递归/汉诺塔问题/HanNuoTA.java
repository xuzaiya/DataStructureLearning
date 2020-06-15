package 数据结构与算法.递归.汉诺塔问题;

public class HanNuoTA {
    public static void main(String[] args) {
        move(3,"A","B","C");
    }

    public static void move(int dish,String from,String temp, String to){
        if (dish == 1 ){
            System.out.println("将盘子"+dish+"从塔座"+from+"移到目标塔座"+to);
        }else{
            move(dish-1,from,to,temp); //A为初始塔座，B为目标塔座，C为中价塔座
            System.out.println("将盘子"+dish+"从塔座"+from +"移到目标塔座"+to);
            move(dish-1,temp,from,to);//B为初始塔座，C为目标塔座，A为中介塔座
        }
    }
}
