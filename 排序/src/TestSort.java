import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @program: 排序
 * @description
 * @author: matilda
 * @create: 2020-05-22 19:01
 **/
public class TestSort {

    //直接插入排序
    //时间复杂度：
    //      最坏情况是：O(n^2)     最好情况（有序的情况）是：O(n)
    //      越有序越快
    //空间复杂度：O(1)
    //稳定性：稳定
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (array[j] > tmp){
                    array[j+1] = array[j];
                }else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }


    //希尔排序
    public static  void  shellSort(int[] array) {
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }

    public static void shell(int[] array,int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i-gap
            for (; j >= 0 ; j = j - gap) {
                if (array[j] > tmp){
                    array[j + gap] = array[j];
                }else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }


    //选择排序
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }


    //堆排序
    //时间复杂度：O(nlog2(n))     不管有序和无序都是
    //空间复杂度：O(1)
    //稳定性：不稳定
    public static void heapSort(int[] array){
        createHeap(array);
        int end = array.length-1;
        while (end > 0){
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array,0,end);
            end--;
        }
    }
    public static void createHeap(int[] array){
        for (int i = (array.length-1-1)/2; i >= 0; i--) {
            adjustDown(array,i,array.length);
        }
    }
    public static void adjustDown(int[] array,int root,int len){
        int parent = root;
        int child = 2*parent+1;
        while (child < len){
            if (child+1 < len && array[child] < array[child+1]){
                child++;
            }
            if (array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;

                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }


    //冒泡排序
    //时间复杂度：O(n^2)
    //空间复杂度：O(1)
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
    //优化后
    public static void bubbleSort1(int[] array){
        boolean flg = false;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if (flg == false){
                return;
            }
        }
    }


    //快速排序
    public static void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = array.length-1;
        int par = partition(array,left,right);

        stack.push(left);
        stack.push(par-1);
        stack.push(par+1);
        stack.push(right);

        while (!stack.isEmpty()) {
            left = stack.pop();
            right = stack.pop();
            par = partition(array,left,right);
            if (par > left + 1) {
                stack.push(left);
                stack.push(par-1);
            }
            if (par < right - 1) {
                stack.push(par+1);
                stack.push(right);
            }
        }

    }


    public static int partition(int[] array,int low,int high) {
        int tmp = array[low];
        while (low < high){
            while (low < high && array[high] >= tmp){
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= tmp){
                low++;
            }
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }

    //三数取中法
    public static void three_num_mid(int[] array,int left,int right) {
        //array[mid] <= array[left] <= array[high]
        int mid = (left + right)/2;
        if (array[left] > array[right]){
            swap(array,left,right);
        }
        if (array[left] > array[mid]){
            swap(array,left,mid);
        }
        if (array[right] < array[mid]){
            swap(array,right-1,mid);
        }
    }
    public static void swap(int[] array,int left,int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void quick(int[] array,int left,int right) {
        if(left >= right) {
            return;
        }
        int par = partition(array, left, right);
        quick(array,left,par-1);
        quick(array,par+1,right);
    }
    public static void quickSort1(int[] array) {
        quick(array,0,array.length-1);
    }


    public static void main1(String[] args) {
        int[] array = new int[10_0000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = i;//有序的
            //array[i] = random.nextInt(10_0000);//无序的
        }
        long start = System.currentTimeMillis();
        insertSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end-start);//排序的时间
    }

    public static void main(String[] args) {
        int[] array = {5,2,0,4,1,9};
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
