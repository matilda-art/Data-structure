/**
 * @program: Java对象的比较
 * @description
 * @author: matilda
 * @create: 2020-05-27 17:11
 **/
class OuterClass{
    public int data1 = 1;
    public static int data2 = 2;

    //实例内部类：可以看做是一个普通的实例数据成员
    //实例内部类是否有额外的开销：有。因为实例内部类包含外部类的this
    //实例内部类当中是否可以定义静态的数据成员？不可以。
    //但是我们可以做到可以，只要是编译时期确定的值。（加final）
    class InnerClass{
        public int data1 = 11;
        public int data3 = 3;
        public static final int a = 99;//编译的时候初始化

        public void func(){
            System.out.println(data1);//局部变量优先 11
            System.out.println(OuterClass.this.data1);//外部类对象的引用 1
            System.out.println("innerclass");
        }
    }
}

public class TestDemo4 {
    public static void main(String[] args) {
        //通过外部对象的引用来调用实例内部对象
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.func();
    }
}
