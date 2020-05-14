import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: List的使用
 * @description
 * @author: matilda
 * @create: 2020-05-12 13:11
 **/

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(17);
        list.add(11);
        list.add(5);
        Collections.sort(list);
        System.out.println(list);
    }
}
