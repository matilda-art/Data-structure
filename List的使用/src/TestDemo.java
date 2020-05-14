import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.ArrayList;

/**
 * @program: List的使用
 * @description
 * @author: matilda
 * @create: 2020-05-12 09:24
 **/
//使用A这个泛型类
    class A<T> {
        T value;

        A(T value) {
            this.value = value;
        }

        T get() {
            return value;
        }
    }

class TestDemo{
    public static void main(String[] args) {
        A<String> a = new A<>("99");
        System.out.println(a.get());
    }
}