import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

/**
 * @program: 实现LinkedList类和ArrayList类
 * @description
 * @author: matilda
 * @create: 2020-05-13 11:27
 **/
public class ListDemo {
    public static void main(String[] args) {
        List<String> courses = new ArrayList<>();
        courses.add("C 语言");
        courses.add("Java SE");
        courses.add("Java Web");
        courses.add("Java EE");
        courses.add("C 语言");

        System.out.println(courses);

        System.out.println(courses.get(0));
        System.out.println(courses);
        courses.set(0, "计算机基础");
        System.out.println(courses);
        //截取部分 [1, 3)
        List<String> subCourses = courses.subList(1, 3);
        System.out.println(subCourses);

        List<String> courses2 = new ArrayList<>(courses);
        System.out.println(courses2);
        List<String> courses3 = new LinkedList<>(courses);
        System.out.println(courses3);
        ArrayList<String> courses4 = (ArrayList<String>) courses2;

        System.out.println(courses4);
        LinkedList<String> courses5 = (LinkedList<String>) courses3;
        System.out.println(courses5);
    }
}