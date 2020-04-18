package MyHashSet;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class MyHashSet {
    public static void main(String[] args) {
        Stu s1=new Stu(11,"张三");
        Stu s2=new Stu(12,"李四");
        Stu s3=new Stu(11,"张三");
        Stu s4=new Stu(11,"王五");
        int h1=s1.hashCode();
        int h3=s3.hashCode();
        int h2=s2.hashCode();
        System.out.println(h1+" "+h3+" "+h2);
        HashSet<Stu> hashSet=new HashSet<>();//无序，不允许重复
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);
        hashSet.add(s4);
        System.out.println(hashSet);
        LinkedHashSet<Stu> linkedHashSet=new LinkedHashSet<>();//有序，不允许重复
        linkedHashSet.add(s1);
        linkedHashSet.add(s2);
        linkedHashSet.add(s3);
        linkedHashSet.add(s4);
        System.out.println(linkedHashSet);
    }
}