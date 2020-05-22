import sun.security.x509.GeneralName;

import java.util.Arrays;

/**
 * @program: 堆
 * @description
 * @author: matilda
 * @create: 2020-05-21 19:17
 **/
public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    /*root 每棵子树的开始位置
      len  结束位置*/


    //向下调整(大堆)
    public void adjustDown(int root,int len) {
        int parent = root;
        int child = 2*parent+1;
        while (child < len){
            //0、判断是否有左右孩子  有的话 找到最大值 C下标表示最大值下标
            if (child+1 < len){
                child = this.elem[child] > this.elem[child+1] ? child : child+1;
            }
            //代码指向到这里，c表示最大值下标
            if (this.elem[child] > this.elem[parent]){
                //交换
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;

                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    //创建堆
    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        //i：每棵子树的根节点下标
        for (int i = (this.usedSize-1-1)/2; i >= 0 ; i--) {
            adjustDown(i,this.usedSize);
        }
    }

    //打印堆
    public void show(){
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
    }

    //放入val元素
    public void push(int val) {
        //0、堆是否是满的--》扩容
        if (isFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        //1、放到数组的最后一个位置
        int index = this.usedSize;
        this.elem[index] = val;
        usedSize++;
        //2、进行调整
        adjustUp(this.usedSize-1);
    }


    //向上调整
    public void adjustUp(int child) {
        int parent = (child-1)/2;
        while (child > 0){
            if (this.elem[child] > this.elem[parent]) {
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;

                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }


    public void pop(){
        //是否是空的
        if (isEmpty()) return;
        //最后一个元素和栈顶元素交换
        int tmp = this.elem[0];
        this.elem[0] = this.elem[usedSize-1];
        this.elem[usedSize-1] = tmp;
        this.usedSize--;
        //调整0号下标的这棵树
        adjustDown(0,usedSize-1);

    }

    public boolean isEmpty(){
        return this.usedSize == 0;
    }

    //堆顶元素
    public int peek(){
        if (isEmpty()){
            return -1;
        }
        return this.elem[0];
    }

    //堆排序
    public void heapSort() {
        int end = this.usedSize-1;
        while (end > 0){
            //交换0号位置和end位置
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            //调整
            adjustDown(0,end);
            end--;
        }
    }

}
