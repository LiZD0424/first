package demo;

public class Zi extends Fu {
    public int numzi=20;
    public int num=200;
    public String str="子类成员变量";


    @Override
    public void show(){
        System.out.println(num);
    }//子类重写方法的返回值范围必须小于等于父类方法的返回值范围Object>String...子类方法修饰符大于等于父类方法修饰符public>protect>(default)留空>private
    @Override
    public void m(){
        System.out.println("子类重写方法调用");
    }
    public void m1(){
        System.out.println("子类方法调用");
    }
    public Zi() {
        //this(1,2);//用this调用本类的另一个构造方法 和super一样只能是第一个语句 也只能是唯一的一个 this和super不能一起用
        System.out.println("子无参父无参构造函数");
    }

    public Zi(int numzi, int num) {
        this.numzi = numzi;
        this.num = num;
        System.out.println("子全参父无参构造函数");
    }
    /*public Zi(int numzi, int num) {
        super(numzi, num);
        System.out.println("子无参父全参构造函数");
    }*/

    public Zi(int numfu, int num, int numzi, int num1) {
        super(numfu, num);//写在第一行，只有子类构造方法才能调用父类构造方法，调用父类含参构造方法必须用super，无参不用写；
        this.numzi = numzi;
        this.num = num1;
        System.out.println("子全参父全参构造函数");
    }
}
