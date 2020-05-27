import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @program: Java对象的比较
 * @description
 * @author: matilda
 * @create: 2020-05-27 17:00
 **/
class Animal{
    public void func(){
        System.out.println("Animal:func()");
    }
}

public class TestDemo3 {
    public static void main(String[] args) {
        new Animal(){
            @Override
            public void func() {
                System.out.println("重写了这个方法");
            }
        }.func();
    }
}
