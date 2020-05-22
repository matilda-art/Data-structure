/**
 * @program: 堆
 * @description
 * @author: matilda
 * @create: 2020-05-22 10:19
 **/
public class TestDemo {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        testHeap.createHeap(array);
        testHeap.show();
        testHeap.push(80);
        testHeap.show();
        testHeap.heapSort();
        testHeap.show();
    }
}
