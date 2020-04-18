package demo;

public class MyInterfaceImpl implements MyInterface {
    private int a;

    @Override
    public void show() {
        System.out.println("接口实现");
    }

    @Override
    public void showa() {
        System.out.println(a);
    }

    @Override
    public void setA(int a) {
        this.a = a;
    }
}
