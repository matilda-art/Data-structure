import java.util.Comparator;

/**
 * @program: Java对象的比较
 * @description
 * @author: matilda
 * @create: 2020-05-27 16:01
 **/
public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.age - o2.age;
    }
}
