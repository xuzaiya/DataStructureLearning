package java基础知识总结与回顾.类型转换;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //1.string ->int
        //String str1 = "123";
        //int value = Integer.valueOf(str1);
        //int value2 = Integer.parseInt(str1);
        //System.out.println(value2);
        //System.out.println(value);

        //2. int -> string
        //int value = 123;
        //String str1 = String.valueOf(value);
        //String str2 =Integer.toString(value);
        //System.out.println(str2);
        //System.out.println(str1);

        //3. Integer -> String
        //Integer a = 123;
        //String str1 = Integer.toString(a);
        //String str2 = a.toString();
        //String str3 = String.valueOf(a);
        //System.out.println(str1);
        //System.out.println(str2);
        //System.out.println(str3);

        //4. String -> Integer
        //String str = "123";
        //Integer value = Integer.valueOf(str);
        //Integer value2 = Integer.parseInt(str);
        //System.out.println(value2);
        //System.out.println(value);

        //5. int -> Integer
        //int a = 123;
        //Integer value = new Integer(a);
        //Integer value2 = Integer.valueOf(a);
        //System.out.println(value2);
        //System.out.println(value);

        //6.Integer -> int
        //Integer a = 123;
        //int value = a.intValue();
        //System.out.println(value);


        //7.String -> float
        //String str = "123";
        //float value = Float.valueOf(str);
        //float value2 = Float.parseFloat(str);
        //System.out.println(value);

        //8. float -> String
        //float a = 123.0f;
        //String str = String.valueOf(a);
        //String str2 = Float.toString(a);
        //System.out.println(str2);
        //System.out.println(str);


        //9.Float -> String
        //Float a = 123f;
        //String str1 = a.toString();
        //String str2 = String.valueOf(a);
        //String str3 = a.toString();
        //System.out.println(str1);

        //10. String -> Float
        //String str = "123";
        //Float value = Float.valueOf(str);
        //Float value2 = Float.parseFloat(str);
        //System.out.println(value);
        //System.out.println(value2);


        //12. String -> char
        //String str = "yangxu";
        //char c = str.charAt(1);
        //System.out.println(c); //a


        //13. char -> String
        //char c = 'c';
        //String str = String.valueOf(c);
        //String str2 = Character.toString(c);
        //String str3 = new Character(c).toString();
        //String str4 = new String(new char[]{'c'});
        //System.out.println(str4);
        //System.out.println(str3);
        //System.out.println(str2);
        //System.out.println(str);


        //14. char[] -> String
        //char [] c = new char[]{'a','b','c'};
        //String str =String.copyValueOf(c);
        //System.out.println(str);


        //15. String -> char[]
        //String str = "yangxu";
        //char[] arr= str.toCharArray();
        //System.out.println(arr);


        //16. Integer[] -> int[]
        //Integer[] arr = new Integer[]{1,2,3,4,5,6,76};
        //int[] arrs = Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
        //System.out.println(arrs);


        //17. int[] -> Integer[]
        //int[] a={1,3,4};
        //Integer[] arr= IntStream.of(a).boxed().collect(Collectors.toList()).toArray(new Integer[0]);
        //Integer[] integers = Arrays.stream(a).boxed().toArray(Integer[]::new);
        //for(Integer i: integers){
        //    System.out.println(i);
        //}


        //18. List<Integer> -> int[]
        //List< Integer > list = new ArrayList<>();
        //list.add(165);
        //list.add(25);
        //list.add(24);
        //list.add(23);
        //int[] int1 = list.stream().mapToInt(Integer::valueOf).toArray();
        //int[] int2 = list.stream().mapToInt(Integer::intValue).toArray();
        //for (int i: int2){
        //    System.out.println(i);
        //}


        //19. int[] -> List<Integer>
        //int[] arr = {1,2,3,4,45};
        //List list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        //20. Integer[] -> List<Integer>
        Integer[] arr= {23,12,14};
        List<Integer> list=Arrays.asList(arr);
        List<Integer> list1 = new ArrayList<>(Arrays.asList(arr));





    }
}
