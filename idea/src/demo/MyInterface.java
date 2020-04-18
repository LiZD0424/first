package demo;

public interface MyInterface {//接口里面可以有常量，抽象方法，默认方法，静态方法，私有方法（1.9）必须用实现类实现接口；如果类没有实现接口中全部抽象方法那这个类必须是一个抽象类。当一个类实现的多个接口中有重复的抽象方法，则只需重写一次；当实现类的直接父类中有和接口内重名的默认方法，优先用父类的，继承大于实现
    public abstract void show();//public abstract 两个修饰符是固定的 可写可不写
    public default void defShow(){//default修饰的默认方法必须有方法体，在接口升级过程中更改以前有的接口实现类很麻烦，为了不发生错误，这样写以前的实现类对象也能调用默认方法。当一个类实现的多个接口中有重复的默认方法，则必须重写此方法

        System.out.println("这是接口的默认方法");
        //pshow();调用接口的私有方法
    }
    public static void stashow(){
        System.out.println("接口静态方法");//通过接口名称.stashow调用，不需要用类实现
    };
    void showa();
    public abstract void setA(int a);
    /*private void pshow(){//普通私有方法，修饰符只用private ，用于多个默认方法之间重复的且不想让实现类实现的部分
    }
    private static void  pshow(){//静态私有方法解决多个静态方法之间重复代码部分
    }*/
    public static final int NUM=10;//常量，必须赋值且不能更改，大写且用下滑线连接
}
