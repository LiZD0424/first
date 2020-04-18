package demo;

public class Keyboard implements USB{
    @Override
    public void off() {
        System.out.println("键盘关");
    }

    @Override
    public void on() {
        System.out.println("键盘开");
    }
    public void work(){
        System.out.println("敲击键盘");
    }
}
