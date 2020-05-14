import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @program: 栈和队列
 * @description
 * @author: matilda
 * @create: 2020-05-14 09:09
 **/
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data = data;
    }
}

public class MyQueue {
    public int usedSize;
    public Node front;//头
    public Node rear;//尾

    //入队
    public boolean offer(int val){
        Node node = new Node(val);
        if (this.rear == null){
            this.rear = node;
            this.front = node;
        }else {
            this.rear.next = node;
            this.rear = node;
        }
        this.usedSize++;
        return true;
    }

    //出队且删除队头元素
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int data = this.front.data;
        this.front = this.front.next;
        return data;
    }

    //查看队头元素
    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return this.front.data;
    }

    //判断是否为空
    public boolean isEmpty(){
        return this.usedSize == 0;
    }

    //队列的大小
    public int size(){
        return this.usedSize;
    }
}
