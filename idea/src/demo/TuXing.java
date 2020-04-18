package demo;

public abstract class TuXing {//抽象方法必须是抽象类，里面也能有普通成员方法，不能直接new抽象类对象，必须用子类继承他并实现抽象类中所有的抽象方法；抽象子类能实现一部分抽象方法，只要抽象子类的子类把剩余未实现的抽象方法实现了就是正确的
    private String name;

    public abstract int mianJi();//计算图形面积的抽象方法，不加{}
    public TuXing(){//抽象方法也能有构造函数，供子类new时创建父类对象默认的super（）
        System.out.println("抽象父类构造方法");
    }

    public String getName() {
        return name;
    }
    public static TuXing getTuXing(){//抽象类不能直接创建对象，使用这个方法相当于多态写法返回一个子类
        TuXing t=new ZhengFangXing();
        return t;
    }

    public void setName(String name) {
        this.name = name;
    }
}
