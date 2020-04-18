package MyCollection;

import java.util.*;

public class MyCollection {//没有索引
    public static void main(String[] args) {
        Collection<String> collection=new ArrayList<>();//使用泛型1.不用数据转换只保存一种数据类型2.将运行期异常提升到编译器异常；缺点：不能保存任意类型数据
        HashSet<String> arr=new HashSet<>();
        collection.add("zhangsan");//添加元素，成功返回true
        collection.add("lisi");
        collection.add("wangwu");
        collection.add("zhaoliu");
        collection.add("zhangsan");
        System.out.println(collection);//集合重写了toString方法 打印名字输出为默认格式的遍历
        collection.remove("zhangsan");//删除参数第一次出现的元素 成功返回true
        System.out.println(collection);
        collection.add("zhangsan");
        System.out.println(collection);
        arr.add("zhangsan");
        arr.add("wangwu");
        collection.removeAll(arr);//删除arr中元素所有出现的地方,arr为Collection任意实现类
        System.out.println(collection);
        boolean a=collection.contains("zhangsan");//判断是否存在元素
        System.out.println(a);
        Object[] o=collection.toArray();//将集合转化为Object数组
        for (Object i : o) {//迭代器实现只能读取 不能增删 所有单列集合都可用
            System.out.println(i);
        }
        ((ArrayList<String>) collection).set(1,"wangwu");//更改集合中索引位置的元素
        ((ArrayList<String>) collection).add(1,"zhaoliu");//在索引出插入元素
        System.out.println(((ArrayList<String>) collection).get(1));//向下转型成子类使用子类成员方法
        Iterator<String> iterator=collection.iterator();//多态写法，调用Collection接口中的iterator方法会创建一个Iterator的实现类对象，指向索引-1位置。内部实现new实现类的功能
        while(iterator.hasNext()){//判断下一位是否还有元素
            System.out.println(iterator.next());//取下一个元素（先输出下一个元素然后指针移动到下一个元素）
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        Collections.shuffle(list);//打乱List接口实现类对象顺序，Set接口实现类对象不可以
        System.out.println(list);
    }

}
