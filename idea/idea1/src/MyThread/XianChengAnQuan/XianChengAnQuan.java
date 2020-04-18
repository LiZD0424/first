package MyThread.XianChengAnQuan;

public class XianChengAnQuan {
    public static void main(String[] args) {
        Runnable r=new Piao();//只new一个实现类对象 ，即方法数据都是同一个，若new多个则方法是一个 数据不共享
        Thread t1=new Thread(r);
        Thread t2=new Thread(r);
        Thread t3=new Thread(r);
        t1.start();
        t2.start();
        t3.start();
    }
}
