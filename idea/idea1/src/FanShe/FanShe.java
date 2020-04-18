package FanShe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/*获取Class对象的方式：
 *      1.Class.forName()将字节码文件载入内存，返回Class对象。多用于配置文件 ，将类名定义在配置文件中。读取文件，加载类
 *      2.类名.Class通过类名的属性Class获取。多用于传参
 *      3.对象.getClass（）在Object类中定义（已经创建对象了）。多用于对象的获取字节码的方式
 * 三种方法获取的Class是相同的，即同一个字节码文件（*.Class）在一次运行的过程中，只会被加载一次。
 * Class对象功能：
 * 1.获取成员变量们
 *      Field[] getFields()  获取所有public修饰的成员变量
 *      Field getField(String name)  获取指定名称的public修饰的成员变量
 *      Field[] getDeclaredFields()获取所有的成员变量，不考虑修饰符,但不能通过get（）方法访问具体某个实例化对象的private成员变量具体值，除非暴力反射setAccessible(true)
 *      Field getDeclaredField(String name)
 * 2.获取构造方法们
 *      Constructor<?>[] getConstructors()//返回public构造方法
 *      Constructor<T> getConstructor(Class<?>... parameterTypes)//构造方法的参数
 *      Constructor<?>[] getDeclaredConstructors()//返回所有构造方法
 *      Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
 * 3.获取成员方法们
 *      Method[] getMethods()//返回public方法 包括从父类继承来的
 *      Method getMethod(String name, Class<?>... parameterTypes)// 第一个参数是方法名，后面是参数
 *      Method[] getDeclaredMethods()//返回所有方法，不包括继承的方法
 *      Method getDeclaredMethod(String name, Class<?>... parameterTypes)
 * 4.获取类名
 *      String getName()//获取类名（包名.类名）
 *
 * 获取成员变量后的操作：
 *  1.获取此成员变量的指定实例化对象的值，get（Object o）参数为指定实例化对象对象
 *  2.设置此成员变量的指定实例化对象的值，set（Object o,Object value）参数为指定实例化对象对象,设置的值
 *
 *  获取构造方法后的操作
 *  通过newInstance（）方法返回一个Object类对象（注意返回的不是本类对象），创建一个新的实例化对象
 *  若想使用一个空参的构造方法，直接使用Class中的newInstance（）方法构造，不用在获取特定的构造方法了，也是返回Object类对象
 *
 * 获取成员方法后的操作
 * 通过invoke（）方法执行此成员方法，参数第一个是此类的实例化对象，后面的是此成员方法的参数
 * getname（），获取方法名（暂时不知道有什么用）
 * */
public class FanShe {
    public static void main(String[] args) throws Exception {
        Class<?> cls1 = Class.forName("FanShe.Person");
        Class<FanShe> cls2 = FanShe.class;
        Person p1 = new Person();
        Person p2 = new Person();
        Class<? extends Person> Class3 = p1.getClass();
        /*System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);*/

        Field[] field1 = cls1.getFields();
        for (Field field : field1) {
            System.out.println(field);
        }
        Field field2=cls1.getField("a");
        System.out.println(field2);


        System.out.println(field2.get(p1));//获取实例化对象p1的成员变量a的值
        field2.set(p1,"张三");//设置实例化对象p1的成员变量a的值
        System.out.println(p1.a);


        System.out.println("=======================");


        Field[] field3=cls1.getDeclaredFields();
        for (Field field : field3) {
            System.out.println(field);
        }

        Field field4=cls1.getDeclaredField("d");
        field4.setAccessible(true);//暴力反射
        System.out.println(field4.get(p1));

        Constructor[] c=cls1.getDeclaredConstructors();
        for (Constructor constructor : c) {
            System.out.println(constructor);
        }

        Constructor c1=cls1.getConstructor(String.class,int.class);//获取指定参数的构造器
        Object p3=c1.newInstance("李四",11);//调用Constructor类中的newInstance（）方法创建一个新的此类对象，注意返回的是Object类对象
        System.out.println(p3);

        Object p4=cls1.newInstance();//若使用空参构造方法，不用获取空can的构造方法了，直接使用class类中的newInstance()方法
        System.out.println(p4);

        Method[] m=cls1.getMethods();
        for (Method method : m) {
            System.out.println(method);
        }

        Method m1=cls1.getMethod("eat",null);//参数是方法名
        m1.invoke(p1);

        Method m2=cls1.getMethod("eat",String.class);
        m2.invoke(p1,"food");//参数第一个是此类对应的实例化对象，后面是此成员方法的参数

        String s=cls1.getName();//包名.类名
        System.out.println(s);
    }

}
