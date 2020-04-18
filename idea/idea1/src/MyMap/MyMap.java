package MyMap;
//key不能重复Value能重复，key和value的类型可以不一样，key和value都可以为null
//hashTable的key和value都不能为空 子类properties是唯一和io流相结合的集合
import MyDate.Person;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyMap {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap=new HashMap<>();
        Integer a= hashMap.put("张三",1);//put添加一个元素对，返回对应key被替换的value值，一个key的第一次添加返回null。 支持自动拆箱,推荐使用包装类，因为可能有null值
        Integer b= hashMap.put("李四",2);
        Integer c= hashMap.put("张三",3);
        System.out.println(hashMap);
        //System.out.println(a);
        //System.out.println(b);
        System.out.println(c);
        int d=hashMap.get("张三");//通过key值返回value 支持自动拆箱,推荐使用包装类，因为可能有null值
        System.out.println(d);
        int e=hashMap.remove("张三");//根据key值移除数据对，返回对应value值，支持自动拆箱。推荐使用包装类，因为可能有null值
        System.out.println(e);
        Boolean f=hashMap.containsKey("张三");//判断是否有key
        System.out.println(f);
        Boolean g=hashMap.containsValue(2);//判断是否有value
        System.out.println(g);
        hashMap.put("张三",1);
        hashMap.put("王五",3);
        System.out.println(hashMap);
        //遍历map的第一种方法，使用keySet（）成员方法得到key的set视图，set视图中元素即为key值 ，再用get（）方法得到对应value值，故遍历此set视图就可遍历value值和map
        Set<String>str=hashMap.keySet();//返回key的set类型数据
        Iterator<String> it=str.iterator();//迭代器遍历
        while(it.hasNext()){
            String s= it.next();
            System.out.println(hashMap.get(s));
        }
        for (String s : str) {//增强for遍历
            System.out.println(hashMap.get(s));
        }
        //遍历map的第二种方法，使用entrySet（）成员方法得到内部接口entry<k,v>的set视图，set视图中元素即为键值对，故遍历此set视图就能遍历map
        Set<Map.Entry<String,Integer>> set=hashMap.entrySet();//entry是map的内部接口，里面记录着map中的键值对关系
        Iterator<Map.Entry<String ,Integer>> iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : set) {
            System.out.println(stringIntegerEntry);
        }
        //自己定义的类当key ，必须重写hashcode（）和equals（）方法，为了显示自己定义类的内容而不是地址的hash值要重写toString（）方法
        HashMap<Person,Integer> hash=new HashMap<>();
        Person p1=new Person("aaaa","1111");
        Person p2=new Person("bbbb","2222");
        Person p3=new Person("cccc","3333");
        Person p4=new Person("aaaa","4444");
        hash.put(p1,1);
        hash.put(p2,2);
        hash.put(p3,3);
        hash.put(p4,4);
        System.out.println(hash);
        Set<Person> people=hash.keySet();
        Iterator<Person> iterator1 = people.iterator();
        while(iterator1.hasNext()){
            System.out.println(hash.get(iterator1.next()));
        }
        Set<Map.Entry<Person,Integer>> set1=hash.entrySet();
        for (Map.Entry<Person, Integer> personIntegerEntry : set1) {
            System.out.println(personIntegerEntry);
        }
    }
}
