package MyCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyCollections {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "a", "b", "c", "d", "e");//一次添加多个元素
        System.out.println(arrayList);
        Collections.shuffle(arrayList);//打乱顺序
        System.out.println(arrayList);
        Stu s1 = new Stu(10, "张三");
        Stu s2 = new Stu(11, "李四");
        Stu s3 = new Stu(12, "李三");
        Stu s4 = new Stu(13, "王五");
        Stu s5 = new Stu(12, "张三");
        ArrayList<Stu> a = new ArrayList<>();
        Collections.addAll(a, s1, s2, s3, s4, s5);
        System.out.println(a);
        Collections.sort(a);//按照类里实现的compareTo方法排序
        System.out.println(a);
        Collections.sort(a, new Comparator<Stu>() {//重写Comparator接口比较器
            @Override
            public int compare(Stu o1, Stu o2) {//前减后为升序
                return o1.getAge() - o2.getAge();
            }
        });
        Collections.sort(a, (o1, o2) -> {
            if (o1.getAge() == o2.getAge())
                return o1.getName().charAt(0) - o2.getName().charAt(0);
            return o1.getAge() - o2.getAge();
        });
        System.out.println(a);
    }
}
