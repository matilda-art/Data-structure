import java.util.Arrays;

/**
 * @program: Java对象的比较
 * @description
 * 缺点：每次业务不同，需要去修改类本身
 * 重点：自定义类型为什么可以实现可比较？
 * @author: matilda
 * @create: 2020-05-27 15:33
 **/
class Student implements Comparable<Student>{
    public int age;
    public int score;
    public String name;

    public Student(String name,int age,int score){
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}

public class TestDemo1 {

    public static void main(String[] args) {
        Student student1 = new Student("朱一龙",32,99);
        Student student2 = new Student("韩烁",18,100);
        Student[] students = new Student[2];
        students[0] = student1;
        students[1] = student2;

        Arrays.sort(students);
        System.out.println(students);
    }

    public static void main1(String[] args) {
        Student student1 = new Student("朱一龙",32,99);
        Student student2 = new Student("韩烁",18,100);
        if (student1.compareTo(student2) > 0){
            System.out.println("student1大于student2年龄");
        }
    }
}
