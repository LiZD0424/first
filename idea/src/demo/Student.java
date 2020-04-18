package demo;

import java.util.Objects;

public class Student {
    private int id;//学号
    private boolean m;//性别
    private String name;//姓名
    static int c;//同班同学班级一样故可共同使用一个班级，static修饰的成员变量和成员函数是属于类的不是属于对象的
    private static int idCount;//学号 累加器必须可共用
    public USB usb;//接口作为成员变量

    public void setUsb(USB usb) {
        this.usb = usb;
    }

    public void showUSB(){
        usb.on();
    }
    static{ //静态代码块用到该类时只执行一次，一般用来一次性的对静态成员进行赋值
        System.out.println("静态代码块执行");
    }
    public static void fcs(){//类名称调用，1.静态方法只能访问静态变量,不能访问非静态变量，内存中先有的静态内容，后有的成员内容先人不能知道后人，后人能知道先人；2.静态方法中不能有this指针，静态方法和对象没关系，this表示当前对象，谁调用的方法谁就是当前对象
        System.out.println("静态方法");
    }
    public void fc(){//实例化后对象调用，成员函数能访问静态变量
        System.out.println("成员方法");
    }
    public Student() {
        System.out.println("构造函数执行");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student( boolean m, String name) {
        System.out.println("构造函数执行");
        this.id = ++idCount;
        this.m = m;
        this.name = name;
    }

    public boolean isM() {//boolean类型get方法用is
        return m;
    }

    public void setM(boolean m) {
        this.m = m;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
