package java8.methodReference;

public class Student {
    private String name;
    private int score;


    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public void setScore(int score) {
        this.score = score;
    }

    // 静态方法  负数表示的正序
    public static int compareStudentByScore(Student student1,Student student2){
        return student1.getScore()-student2.getScore();
    }

    //静态方法
    public static int compareStudentByName(Student student1,Student student2){
        return student1.getName().compareTo(student2.getName());
    }

    // 实例方法
    public int compareByScore(Student student){
        return this.getScore()-student.getScore();
    }

    //实例方法
    public int  compareByName(Student student){
        return this.getName().compareTo(student.getName());
    }
}
