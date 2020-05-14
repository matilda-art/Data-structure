import java.util.ArrayList;
import java.util.List;

/**
 * @program: List的使用
 * @description
 * @author: matilda
 * @create: 2020-05-12 13:15
 **/
//删除第一个字符串当中出现的第二个字符串中的字符。
    //例如：String str1 = “welcome to bit”;String str2 = "come";
    //          输出结果 ：wl t bit


public class RemoveList {
    public static List<Character> func(String str1, String str2){
        List<Character> list = new ArrayList<>();
        for (int i = 0;i < str1.length();i++){
            if (!str2.contains(str1.charAt(i)+"")){
                list.add(str1.charAt(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        List<Character> ret = func(str1,str2);
        for (char ch:ret) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
