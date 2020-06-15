package 数据结构与算法.递归.组合选择一只队伍;
/*
组合问题： 5个人里面挑3个人，看有多少种组合方法
 */
public class Combination {
    private char[] persons; // 组中所有可供选择的人员
    private boolean[] selects; //标记成员是否被选中，选中为true

    public Combination(char[] persons){
        this.persons = persons;
        selects = new boolean[persons.length];
    }

    public void showTeams(int teamNumber){
        combination(teamNumber,0);
    }

    /*
        teamNumber:需要选择的队员数
        index： 从第几个队员开始选择
     */
    public void combination(int teamNumber,int index){
        if (teamNumber == 0){
            //当teamNumber为0时找到一组
            for (int i=0;i<selects.length;i++){
                if (selects[i] == true){
                    System.out.print(persons[i]+ " ");
                }
            }
            System.out.println();
            return ;
        }
        if (index>=persons.length){
            return ;
        }
        selects[index] = true;
        combination(teamNumber-1,index+1);
        selects[index] = false;
        combination(teamNumber,index+1);
    }

    public static void main(String[] args) {
        char[] persons = {'A','B','C','D','E'};
        Combination cb = new Combination(persons);
        cb.showTeams(3);
    }


}
