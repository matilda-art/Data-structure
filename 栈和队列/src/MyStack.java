import java.util.Arrays;

/**
 * @program: 栈和队列
 * @description
 * @author: matilda
 * @create: 2020-05-14 09:09
 **/
public class MyStack {
    public int[] elem;//数组
    public int top;//表示当前可以存放数据元素的下标

    public MyStack() {
        this.elem = new int[10];
    }

    //入栈
    public void push(int val) {
        if (full()){
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);//扩容
        }
        this.elem[top++] = val;
    }

    //判断是否为空
    public boolean empty() {
        return this.top == 0;
    }

    //判断是否已满
    public boolean full() {
        return this.top == this.elem.length;
    }

    //删除栈顶元素
    public int pop() {
        if (empty()){
            throw new RuntimeException("栈空！");
        }
        int data = this.elem[this.top-1];
        top--;
        return data;
        //return this.elem[--this.top];
    }

    //查看栈顶元素
    public int peek() {
        if (empty()){
            throw new RuntimeException("栈空！");
        }
        return this.elem[this.top-1];
    }

    //栈的大小
    public int size() {
        return this.top;
    }

}
