import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: Java对象的比较
 * @description
 * topK问题
 * @author: matilda
 * @create: 2020-05-27 16:20
 **/
class MyComparator implements Comparator<Integer>{


    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

public class TopK {

    //先把数组前K个元素建立一个堆，后面每拿到一个元素就和堆顶元素进行比较
    //前k个最大的建立小堆，前K个最小的建立大堆
    public static Integer[] topK(int[] array,int k){

        MyComparator myComparator = new MyComparator();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < array.length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.offer(array[i]);
            } else {
                Integer val = maxHeap.peek();
                if (val != null && val > array[i]) {
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        Integer[] ret = new Integer[k];
        for (int i = 0; i < k; i++) {
            int v = maxHeap.poll();
            ret[i] = v;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] array = {10,1,7,8,18,20,15};
        Integer[] ret = topK(array,4);
        System.out.println(Arrays.toString(ret));
    }
}
