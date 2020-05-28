import java.util.ArrayList;

/**
 * @program: 泛型
 * @description
 * @author: matilda
 * @create: 2020-05-28 11:10
 **/

//打印集合中的所有元素
class GenericList{
    public static <T> void printList(ArrayList<T> list){
        for (T val:list) {
            System.out.print(val+" ");
        }
        System.out.println();
    }

    //?:通配符，一种泛型
    //通配符一般用于读取 add（？）
    //泛型一般用于写入   add（T）

    //通配符既有上界，也有下界 extends  super
    public static <T> void printList2(ArrayList<?> list){
        for (Object val:list) {
            System.out.print(val+" ");
        }
        System.out.println();
    }
}



public class TestDemo1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        GenericList.printList(list);
    }
}
