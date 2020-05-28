/**
 * @program: 泛型
 * @description
 * @author: matilda
 * @create: 2020-05-26 19:04
 **/

//写一个方法，该方法传入参数T[] ，找到最大值并且返回
/*
class Generic<T>{
    public T max(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]){
                max = array[i];
            }
        }
        return max;
    }
}
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//写一个泛型类，包含一个方法。该方法是找到数组当中的最大值
//T extends Comparable<T>  上界
//T一定是实现了Comparable接口的
//泛型没有下界
class Generic<T extends Comparable<T>> {
    public T findMax(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0){
                max = array[i];
            }
        }
        return max;
    }
}

//类型推导 -> 根据实参的类型推导出形参的类型
class Generic2{
    public static <T extends Comparable<T>> T maxNum(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0){
                max = array[i];
            }
        }
        return max;
    }
}

public class TestDemo {

    public static void main(String[] args) {
        Integer[] array = {12,5,7,22,90};
        System.out.println(Generic2.maxNum(array));

        String[] strings = {"abc","hello","school"};
        System.out.println(Generic2.maxNum(strings));
    }

    public static void main1(String[] args) {
        Generic<Integer> generic = new Generic<>();
        Integer[] array = {12,8,9,11,5,3},
        System.out.println(generic.findMax(array));;
    }
}
