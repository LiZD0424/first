package demo;

public class Computer {
    public void on(){
        System.out.println("电脑开");
    }
    public void off(){
        System.out.println("电脑关");
    }
    public void use(USB usb){
        usb.on();
        if(usb instanceof Mouse){
            Mouse mouse=(Mouse)usb;
            mouse.work();
        }else if(usb instanceof Keyboard){
            Keyboard keyboard=(Keyboard)usb;
            keyboard.work();
        }
        usb.off();
    }
}
