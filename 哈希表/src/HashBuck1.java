import java.util.HashMap;

/**
 * @program: 哈希表
 * @description
 * 哈希表：Map
 * 增删查改，时间复杂度均为：O(1)
 * @author: matilda
 * @create: 2020-05-29 20:10
 **/
class HashBuck {

    static class Node {
        public int key;
        public int val;
        public Node next;
        public Node(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array = new Node[10];
    public int usedSize;

    //在对应位置放入数据
    public void put(int key,int val) {

        int index = key % array.length;//找到位置
        for (Node cur = array[index];cur != null;cur = cur.next) {
            if(cur.key == key) {
                //key相同，则更新val值
                cur.val = val;
                return;
            }
        }
        //链表中没有找到相同元素，则用头插法进行插入
        Node node = new Node(key,val);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;

        //不能一直插入，必须要规定负载因子
        if(loadFactor() > 0.75) {
            resize();//扩容
        }

    }

    //扩容：需要进行重新哈希
    public void resize() {
        Node[] newArray = new Node[2*this.array.length];
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                //头插法
                Node curNext = cur.next;
                int index = cur.key % newArray.length;
                cur.next = newArray[i];
                newArray[index] = cur;
                cur = curNext;
            }
        }
        array = newArray;
    }

    public double loadFactor(){
        return this.usedSize*1.0 / this.array.length;
    }


    public int get(int key){
        int index = key % array.length;
        Node cur = array[index];

        while (cur != null){
            if (cur.key == key){
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
}

public class HashBuck1{
    public static void main(String[] args) {
       HashBuck hashBuck = new HashBuck();
        for (int i = 1; i < 4; i++) {
            hashBuck.put(i,i);
        }
        hashBuck.put(11,101);
        System.out.println(hashBuck.get(11));
    }
}
