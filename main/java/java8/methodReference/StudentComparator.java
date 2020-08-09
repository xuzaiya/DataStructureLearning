package java8.methodReference;

public class StudentComparator {
    public int compareStudentByScore(Student student,Student student1){
        return student.getScore()-student1.getScore();
    }

    public int compareStudentByName(Student student,Student student1){
        return student.getName().compareTo(student1.getName());
    }
}
