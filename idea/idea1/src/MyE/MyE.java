package MyE;

import java.util.ArrayList;
import java.util.Iterator;

public class MyE {
    public static void main(String[] args) {
        EClass<String> eClass = new EClass<>(1, "张三");
        System.out.println(eClass);
        eClass.setName("李四");
        System.out.println(eClass);
        EMethod eMethod = new EMethod();
        eMethod.show("sasd");
        EMethod.shows("dsad");
        MyInterfaceImpl1 myInterface1 = new MyInterfaceImpl1();
        myInterface1.show("asdad");
        MyInterfaceImpl2<Integer> myInterfaceImpl2 = new MyInterfaceImpl2<Integer>();
        myInterfaceImpl2.show(1111);
        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        ArrayList<Number>a3=new ArrayList<>();
        ArrayList<Object>a4=new ArrayList<>();
        //Integer extends Number extends Object
        //String extends Object
        //show1(a1);//报错String不是Number的子类
        show1(a2);
        show1(a3);
        //show1(a4);//报错 Object不是Number的子类
        ///show2(a1);//报错 String 不是Integer的父类
        show2(a2);
        show2(a3);
        show2(a4);
        a1.add("aaa");
        a1.add("bbb");
        a2.add(111);
        a2.add(222);
        show(a1);
        show(a2);
    }
    //不了解参数是什么类型的泛型时可用泛型通配符 此时只能读数据，不能创建<?>类型的数组
    public static void show(ArrayList<?> list) {//注意不能是ArrayList<Object>泛型没有继承关系所以不能用类似于多态的写法
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            System.out.println(o);
        }
    }
    public static void show1(ArrayList<? extends Number> list){//受限泛型 参数只能是Number的子类或他自己

    }
    public static void show2(ArrayList<? super Integer> list){//受限泛型 参数只能是Integer的父类或他自己

    }
}
