package demo;

public class Mouse implements USB{
    @Override
    public void off() {
        System.out.println("鼠标关");
    }

    @Override
    public void on() {
        System.out.println("鼠标开");
    }
    public void work(){
        System.out.println("点击鼠标");
    }
}
