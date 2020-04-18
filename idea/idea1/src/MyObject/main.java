package MyObject;

public class main {
    public static void main(String[] args) {
        Student stu1=new Student("张三");
        System.out.println(stu1);//直接输出对象名用的是Object里的toString方法（包名+类名@哈希地址值），可在类里重写；看一个类是否重写了toString方法 就直接打印他对象的名字，如果输出的是地址则此类没有重写toString
        Student stu2=new Student("李四");
        Student stu3=new Student("张三");
        System.out.println(stu2);
        System.out.println(stu3);
        System.out.println(stu1.equals(stu3));
        System.out.println(stu1.equals(null));
        System.out.println(stu1.equals(stu1));
    }
}
