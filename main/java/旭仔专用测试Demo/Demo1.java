package 旭仔专用测试Demo;

public class Demo1 {
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        int[]array = new int[]{1,3,2,5,7,9,6};
        test6(array);
    }

    public static void test1(){
        String s = "i am a student,my english is very well";
        s = s.replaceAll("[^a-zA-Z]","").toUpperCase();
        System.out.println(s);
    }

    public static boolean test2(){
        String ransomNote = "ajdkfjkdjf";
        String magazine = "djfkdfsfafggdjkfjdk";
        if(magazine.length()<ransomNote.length())return false;
        int caps[]  = new int[26];


        for(char c: ransomNote.toCharArray()){
            int index = magazine.indexOf(c,caps[c-'a']); //从指定索引开始，返回字符第一次出现的索引
            if(index == -1)return false;
            caps[c-97] = index+1;
        }
        return true;

        //return true;
    }


    public static void test3(){
        char[] array = {'A','B','C'};
        array[0]= (char) (array[0]+32);
        for (char i : array){
            System.out.println(i);
        }

    }

    //判断一个字符串是否包含另外一个字串
    //如果包含 返回起始索引， 如果不包含返回-1
    public static void test4(){
        String str="abcdefghijklmn";
        String str2 = "abcf";
        System.out.println(str.indexOf(str2));
    }

    //把一个字符串里面的单词首字母变成大写
    public static void test5(){
        String str = "nihao wo yang xu";
        String s = str.replaceAll("[ ]", "%20");
        System.out.println(s);
    }

    public static void test6(int[]array){
        if(array == null || array.length == 0)return ;
        int m = 0;
        for(int i=0;i<array.length;i++){
            if((Math.abs(array[i])%2)!=0){
                int temp = array[i];
                int j = i;
                while(j>m){
                    array[j] = array[j-1];
                    j--;
                }
                m=j+1;
                array[j] = temp;
            }
        }
    }




}
