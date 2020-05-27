import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.PriorityQueue;

/**
 * @program: Java对象的比较
 * @description
 * 比较器：
 * @author: matilda
 * @create: 2020-05-27 15:58
 **/
class Person{
    public int age;
    public int score;
    public String name;

    public Person(String name,int age,int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}

//topK
public class TestDemo2 {

    public static void main(String[] args) {

        AgeComparator ageComparator = new AgeComparator();

        PriorityQueue<Person> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Person("韩烁",18,99));
        priorityQueue.offer(new Person("朱一龙",32,99));

        System.out.println(priorityQueue);
    }

    public static void main1(String[] args) {
        Person person1 = new Person("朱一龙",32,99);
        Person person2 = new Person("韩烁",18,100);

        AgeComparator ageComparator = new AgeComparator();

        System.out.println(ageComparator.compare(person1,person2));
    }
}
