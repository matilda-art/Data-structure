import java.util.*;

/**
 * @program: Map和Set
 * @description
 * @author: matilda
 * @create: 2020-05-28 15:35
 **/
public class TestDemo {

    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int[] array = {7,2,9,18,56,15,3};
        for (int i:array) {
            bsTree.insert(i);
        }
        bsTree.proOrder(bsTree.root);
        System.out.println();
        bsTree.inOrder(bsTree.root);
        System.out.println();
        System.out.println(bsTree.search(18));
    }

    //十万个数据，统计重复数字及出现的次数
    public static void main5(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        //key -> 关键字重复的数字
        //value -> 重复的数字出现的次数
        for (Integer key:list) {
            if (map.get(key) == null){
                map.put(key,1);
            }else {
                Integer val = map.get(key);
                map.put(key,val+1);
            }
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            System.out.println(entry.getKey()+"这个数字出现的次数："+entry.getValue());
        }
    }

    //大数据的去重问题
    //十万个数据当中有重复的元素，请去掉重复的元素
    public static void main4(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        HashSet<Integer> set = new HashSet<>();
        for (Integer val : list) {
            set.add(val);//set的特性：不能存放重复元素
        }
        System.out.println(set);
    }


    //找出十万个数据中第一个重复的数据
    public static void main3(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        HashSet<Integer> set = new HashSet<>();
        for (Integer val:list) {
            if (set.contains(val)){
                System.out.println("找到了第一个重复的元素"+val);
            }else {
                set.add(val);
            }
        }
    }

    public static void main2(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(22);
        set.add(31);
        set.add(5);
        Iterator<Integer> it = set.iterator();//迭代器
        while (it.hasNext()){
            System.out.println(it.next());
            //打印it的下一个，并且it向后走一步
        }
    }

    public static void main1(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"韩烁");
        map.put(2,"陈芊芊");
        map.put(3,"裴恒");
        for (Map.Entry<Integer,String> entry:map.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}

