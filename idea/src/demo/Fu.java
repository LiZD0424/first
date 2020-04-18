package demo;

public class Fu {
    protected int numfu=10;
    protected int num=100;
    public String str="父类成员变量";
    public static void s(){
        System.out.println("jingtaifangfa");
    }
    public void m(){
        System.out.println("父类方法调用");
    }
    public void show(){
        System.out.println(num);
    }
    public void show1(){
        System.out.println(numfu);
    }

    public Fu() {
        System.out.println("父无参构造函数");
    }

    public Fu(int numfu, int num) {
        System.out.println("父全参构造函数");
        this.numfu = numfu;
        this.num = num;
    }
}
