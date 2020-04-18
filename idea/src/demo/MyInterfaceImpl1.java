package demo;

public class MyInterfaceImpl1 implements MyInterface {

    @Override
    public void show() {
        System.out.println("接口实现");
    }

    @Override
    public void defShow() {
        System.out.println("重写了接口的默认方法");
    }

    @Override
    public void showa() {
        System.out.println("Impl1");
    }

    @Override
    public void setA(int a) {

    }
}
