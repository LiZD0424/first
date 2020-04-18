package MyThread;

/* 一.获取线程名称的方式：
 *    1.在Thread子类内部调用String getname（），Thread-0;Thread-1;Thread-2...
 *    2.获取当前正在执行的线程 static Thread currentThread（）返回现在正在执行的线程引用
 * 二.设置线程名称的方式
 *    1.Thread类里的setName（）方法
 *    2.类里定义带参构造方法调用父类带参构造方法
 *
 *
 * */
public class MyThread {
    public static void main(String[] args) {
        Thread thread1 = new Per();
        thread1.start();
        thread1.setName("王五");
        new Per("张三").start();
        new Per("李四").start();
       /* for (int i = 0; i < 10; i++) {
            System.out.println("main"+i);
        }*/
        String name = Thread.currentThread().getName();//main函数没有继承Thread类，不能直接使用getName（）方法，只能获取当前线程的引用后在调用getName（）方法
        System.out.println(name);
        Thread thread2=new Sleep("线程A",1000);
        Thread thread3=new Sleep("线程B",100);
        thread2.start();
        thread3.start();
        MyRunnable myRunnable=new MyRunnable(100);
        Thread thread4=new Thread(myRunnable);
        System.out.println(thread4.getName());
        thread4.start();
        //匿名内部类重写父类方法
        Thread thread5=new Thread(){
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        };
        thread5.start();
        //匿名内部类实现接口
        Runnable myRunnable1= new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类1");
            }
        };
        Thread thread6=new Thread(myRunnable1);
        thread6.start();
    }
}
