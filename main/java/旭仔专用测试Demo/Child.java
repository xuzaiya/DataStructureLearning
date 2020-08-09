package 旭仔专用测试Demo;

/**
 * @author xuzaiya
 * @2020/7/22 16:03
 * 文件说明:
 */
public class Child extends  Person {
    private String name ="tom";
    public Child(){
        super();
        System.out.println("this is a  child");
    }

    public static void main(String[] args) {
        Child child = new Child();
       //System.out.println(this.name);
    }

}
