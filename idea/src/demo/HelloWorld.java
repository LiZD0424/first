package demo;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.sql.SQLOutput;
import java.util.*;

public class HelloWorld {


    public static void main(String[] args) {//psvm
        System.out.println("Hello world");//sout
       /* int[] c=new int[5];//动态初始化
        int[] b=new int[]{1,3,0};、、静态初始化
        int[] f={1,2,3};//静态初始化省略，格式省略了new int[]
        int[] e;
        e=new int[5];//有new 的可以拆开
        int[] h;
        h=new int[]{3,4,5};//对
        int[] g;
        g={3,4,5}//不对
        c=b;//这样c是b的引用上面的new int[5]失效
        int len=b.length;
       */
        /*for (int i = 0; i < a.length; i++) {//b.fori
            Scanner sc=new Scanner(System.in);
            a[i]=sc.nextInt();
        }*/
       /* for (int i = 0; i < c.length; i++) {//遍历
            System.out.println(c[i]);
        }*/
       /* int e=new Scanner(System.in).nextInt();//匿名对象 只能使用一次
        System.out.println(e);

        show(new Scanner(System.in));//匿名对象传参*/
       /* Random r=new Random();//随机数
        int i = r.nextInt(10);//0-9
        System.out.println(i);*/
     /*   ArrayList<String> list = new ArrayList<>();//后侧尖括号内容可不写 前面尖括号内要用包装类（引用类型）(基本类型数据没有地址值，集合中保存的都是地址值)sout直接打印list出来的就是内容 toString
        ArrayList<Integer>list1=new ArrayList<>();
        list.add("000");//ArrayList的add方法一定是成功的，其他的List则不一定，返回值为boolean
        list.add("111");
        list.add("222");
        list.add("333");
        System.out.println(list);//[111,222,333]
        String s = list.get(1);//alt+enter
        System.out.println(s);
        String t=list.remove(1);
        System.out.println("被删除的是"+t);
        System.out.println(list);
        System.out.println(list.size());//长度
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list1.add(100);//自动装箱 jdk1.5+int->Integer
        list1.add(200);
        list1.add(300);
        int k=list1.get(0);//自动拆箱 Integer->int
        int n=list1.indexOf(200);//indexOf 找下标
        public static ArrayList<Integer> getSmallList(ArrayList<Integer> list1){}//ArrayList 当做参数和返回值
        ArrayList<Integer> smallList =getSmallList(list1);//调用
        System.out.println(n);*/
        /*String str1=new String();//String  3+1种构造方式 空，字符数组，字节数组，直接创建“双引号” 双引号创建的也是字符串对象JVM帮忙new了
        System.out.println("str1是"+str1);
        char[] a=new char[]{'a','b','c'};
        String str2=new String(a);
        System.out.println("str2是"+str2);
        byte[] b=new byte[]{65,66,67};//String 底层就是字节数组
        String str3=new String(b);
        System.out.println("str3是"+str3);
        String str4="asd";*/
        /*String str="abcdefg";// equals只有参数是字符串且相等时才会返回true其他情况为false；==比较地址new出来的str1与双引号出来的str2即使内容相同也是false；equalsIgnoreCase不区分大小写
        System.out.println("abc".equals(str));//推荐，当str=null时为false
        System.out.println(str.equals("abc"));//不推荐，当str=null时报错，空指针异常
        char a=str.charAt(1);
        int k=str.indexOf("c");
        String str1=str.concat(str);
        System.out.println(str1);
        System.out.println(a+"位置"+k);
        String sub1=str.substring(4);//截取4到末尾
        System.out.println(sub1);
        String sub2=str.substring(2,3);//截取左闭右开区间
        System.out.println(sub2);
        char[] w=str.toCharArray();//String转化为char数组
        System.out.println(w[1]);
        byte[] b=str.getBytes();//String转化为底层byte数组
        System.out.println(b[1]);
        String s=str.replace("cde","**");//替换
        System.out.println(s);
        String s1="aaa,bbb,ccc";
        String[] split = s1.split(",");//分割字符串，返回值为字符串数组;如果是"."要写"\\."
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }*/
        /*Student stu1=new Student(true,"张三");
        stu1.c=123;//不推荐这么写 静态变量应该写 类名.静态变量
        Student stu2=new Student(true,"李四");
        System.out.println(stu1.getName()+" "+stu1.getId()+" "+stu1.c);
        System.out.println(stu2.getName()+" "+stu2.getId()+" "+stu2.c);
        Student.fcs();//静态方法 类.方法
        stu1.fc();//成员方法 对象.方法*/
       /* int[] a={1,21,3};
        String str= Arrays.toString(a);//注意是Arrays不是Array 里面提供大量和数组相关的静态方法 （math 数学相关静态方法 静态变量 ）将数组变为字符串默认形式
        System.out.println(str);//默认升序
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));*/
        /*Fu fu=new Fu();
        Zi zi=new Zi(1,2);
        Zi zi1=new Zi(1,2,3,4);
        System.out.println(zi.numzi);//成员变量：直接访问方法看等号左边是谁就是谁的成员变量；间接访问方法 成员函数get是谁就用谁的，没有向上找
        System.out.println(zi.numfu);
        zi.show();
        zi.show1();*/
        //ZhengFangXing zhengFangXing=new ZhengFangXing();//抽象类
       /* MyInterfaceImpl myInterface=new MyInterfaceImpl();
        myInterface.show();
        myInterface.defShow();
        MyInterfaceImpl1 myInterface1=new MyInterfaceImpl1();
        myInterface1.defShow();
        MyInterface.stashow();
        System.out.println(MyInterface.NUM);*/
       /* Fu fu=new Zi();//向上转型；多态：一个对象有多种形态一直猫既是动物类又是猫类。成员变量，编译看左边运行看左边（成员变量不能重写）；成员函数，编译看左边运行看右边（成员函数重写）。多态代码体现：父类引用指向子类对象 父类名称 对象名=new 子类名称 或者 接口名称 对象名 =new 实现类 成员变量是父类的 子类里复写的成员函数是子类的 其他的成员函数是父类的 不能直接访问子类特有成员函数
        fu.m();//子类中重写的方法调用的子类的 子类没有的父类有的直接调父类的 子类中有的父类中没有的用下面方法调用
        System.out.println(fu.str);//直接访问成员变量等号左边是哪个类就用那个类的
        System.out.println( fu instanceof Zi);//对象 instanceof 类 返回boolean值 父类引用的对象是否是此类的对象
        ((Zi) fu).m1();//向下转型（先instanceof判断，后转型）
        Fu fu1=new Fu();
        ((Zi) fu1).m1();//报错 不能向下找 只能向上找*/
        /*Computer computer = new Computer();//关于接口的多态
        computer.on();
        computer.use(new Mouse());
        computer.use(new Keyboard());
        computer.off();*/
        /*final int a=100;//局部变量基本数据类型加final时其值不能发生改变，只能赋值一次
        final int b;
        b=100;//这样也算赋值一次
        //b=200;//错误
        final Student student=new Student(true,"李子东1");//引用数据类型加final时期地址不能改变 地址里面的内容可以改变
        System.out.println(student.getName());
        //student=new Student();//错误 不能改变其地址值
        Student student1=new Student(true,"李子东2");
        //student=student1;//错误
        student.setName("李子东3");
        System.out.println(student.getName());*/
       /* Body body=new Body();
        body.show();//间接访问内部类 通过外部类方法
        Body.Heart heart=new Body().new Heart();//直接访问内部类
        heart.beat();
        body.showInner();
        USB usb=new USB() {//接口名称 变量名=new 接口名称（）{ 重写方法体 }如果接口的实现类（父类的子类）只用使用一次，可以使用匿名内部类，不用再去创建一个接口的实现类了（子类）
            @Override
            public void off() {
                System.out.println("匿名内部类");
            }

            @Override
            public void on() {
                System.out.println("匿名内部类");
            }
        };
        usb.on();*/
       /*Student student=new Student();//接口作为成员变量
       USB usb1=new USB() {
           @Override
           public void off() {
               System.out.println("studentUSB1");
           }

           @Override
           public void on() {
               System.out.println("studentUSB1");
           }
       };
       student.setUsb(usb1);
       student.showUSB();
       student.setUsb(new USB() {
           @Override
           public void off() {
               System.out.println("studentUSB");
           }

           @Override
           public void on() {
               System.out.println("studentUSB");
           }
       });
        student.showUSB();
        student.usb.on();*/
        /*List<Integer> list=new ArrayList<>();//接口作为参数和返回值 ArrayList类实现了List接口 多态写法
        List<Integer> list1 = addList(list);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        MyInterface myInterface=new MyInterfaceImpl();
        MyInterface m=set(myInterface);
        m.showa();*/
        //红包
       /* Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        List<Integer>list1=new PingJun().list(m,n);
        List<Integer>list2=new SuiJi().list(m,n);
        for (int i = 0; i < n; i++) {
            System.out.println("平均"+list1.get(i));
        }
        System.out.println("**********************");
        for (int i = 0; i < n; i++) {
            System.out.println("随机"+list2.get(i));
        }*/
        /*TuXing t=TuXing.getTuXing();//相当于TuXing t=new ZhengFangXing();
        TuXing t1=new ZhengFangXing();
        System.out.println( t.mianJi());
        System.out.println( t1.mianJi());
        TuXing tuXing=new TuXing() {
            @Override
            public int mianJi() {
                System.out.println("三角形");
                return 0;
            }
        };
        tuXing.mianJi();*/
    }
  /*  public static MyInterface set(MyInterface myInterface){
        myInterface.setA(130);
        MyInterface myInterface1=new MyInterface() {
            @Override
            public void show() {

            }

            @Override
            public void showa() {
                System.out.println("120");
            }

            @Override
            public void setA(int a) {

            }
        };
        return myInterface1;
    }
    public static List<Integer> addList(List<Integer> list){ //接口作为参数和返回值
        list.add(1);
        list.add(3);
        list.add(0);
        return list;
    }*/
   /* public static void show(Scanner sc){//对于本类中的类方法调用时可以省略类名称
        int i = sc.nextInt();
        System.out.println(i);
    }*/

}