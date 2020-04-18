package rushbbbbbbb;

import java.lang.reflect.Array;
import java.util.*;

public class MyFriend {
    public static void main(String[] args) {
        String[] strings = {"aaaaa", "bbbb", "cccc"};
        List<String> s = Arrays.asList(strings);//返回的Arrays.asList() 方法返回的并不是 java.util.ArrayList ，而是 java.util.Arrays 的一个内部类,这个内部类并没有实现集合的修改方法或者说并没有重写这些方法。
        System.out.println(s);
        List<String> s1 = new ArrayList<>(s);//正确将数组转化为ArrayList的方法List list = new ArrayList<>(Arrays.asList("a", "b", "c"))
        s1.add("ssss");
        Object[] objects = s1.toArray();//方法中无参数返回Object数组
        for (Object object : objects) {
            System.out.println(object);
        }
        Collections.reverse(s1);//反转数组
        String[] strings1 = s1.toArray(new String[0]);//<T> T[] toArray(T[] a),由于JVM优化，new String[0]作为Collection.toArray()方法的参数现在使用更好，new String[0]就是起一个模板的作用，指定了返回数组的类型，0是为了节省空间，因为它只是为了说明返回的类型。
        for (String s2 : strings1) {
            System.out.println(s2);
        }
    }
}
