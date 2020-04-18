package MyThread;
/*实现多线程的第二种方法：实现Runnable接口中的run方法，main中先new一个实现类对象，再利用Thread的带runnable参数的构造方法创建Thread对象 在调用start（）方法
*Thread（Runnable r，String name）
* Thread（Runnable r）
*一般不需要重写Thread类方法的时候就不要写Thread的子类，写runnable接口还能避免单继承的局限性
* 增加程序可扩展性（解耦）将设置线程任务和开启线程分离 只需更改线程实现类（new不同的实现类）就能变更线程
* */
public class MyRunnable implements Runnable {
    private int sleepTime;
    public MyRunnable(int sleepTime){
        this.sleepTime=sleepTime;
    }
    @Override
    public void run() {
        System.out.println("线程运行");
    }
}
