import java.util.ArrayList;
import java.util.List;

/**
 * @program: List的使用
 * @description
 * @author: matilda
 * @create: 2020-05-12 12:54
 **/
class Student {
    private String name;
    private String classes;
    private double score;

    public Student(String name,String classes,double score){
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "List{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}

public class ClassMate {
    public static void main(String[] args) {
        Student student1 = new Student("朱一龙","一班",100);
        Student student2 = new Student("石原里美","二班",99);
        Student student3 = new Student("郑云龙","三班",88);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        for (Student s:list) {
            System.out.println(s);
        }
    }
}
