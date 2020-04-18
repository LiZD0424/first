package MyThread.XianChengAnQuan;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
同步安全问题（怎样保证线程间互斥地访问互斥资源的问题）
 * 解决冲突方法一，同步代码块
 *      synchronized(锁对象){可能产生线程安全问题的代码}
 *      同步锁保证了同时之能有一个线程访问可能产生线程安全问题的代码，程序频繁的获取锁，释放锁，降低了程序运行的效率
 * 解决冲突方法二，同步方法
 *      修饰符 synchronized 返回值类型 方法名（参数）{可能产生线程安全问题的代码}，锁对象就是实现类对象本身，就是this
 * 解决冲突方法三，静态同步方法
 *      将互斥资源设为静态变量，可能产生线程安全问题的方法设置为静态方法，锁对象是本类的class属性，即class文件对象（反射）
 *      修饰符 static synchronized 返回值类型 方法名（参数）{可能产生线程安全问题的代码}
 * 解决冲突方法四，Lock接口
 *      1.在成员位置创建一个reentrantLock对象 他实现了Lock接口
 *      2.在有同步安全问题的代码前调用Lock接口中的方法Lock获取锁
 *      3.在有同步安全问题的代码后调用Lock接口中的方法unLock释放锁
 * */
public class Piao implements Runnable {
    private  int n = 100;
    Object object = new Object();//定义锁对象，不能写在run（）方法里，不然每个线程都要创建一个锁对象，同步失效
    Lock l = new ReentrantLock();//第四种方法
 
    @Override
    public void run() {
        //Object object = new Object();不能写在run（）方法里，不然每个线程都要创建一个锁对象，同步失效
       /* while (n>0) {
            synchronized (object) {//方法一.同步代码块，可能产生线程安全问题的代码
                if (n >0) {
                    System.out.println(Thread.currentThread().getName() + "卖了第" + n + "张票");
                    n--;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }*/
        /*while (n > 0) {
            //fenfa();
            fenfassss();
        }*/
        //Lock l = new ReentrantLock();不能写在run（）方法里，不然每个线程都要创建一个锁对象，同步失效
        while (n > 0) {
            l.lock();//获取锁
            try {
                if (n > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖了第" + n + "张票");
                    n--;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                l.unlock();//释放锁，最好放在finally块中，无论是否有异常，最后锁都会被释放
            }

        }
    }

    private /*synchronized*/ void fenfa() {//方法二，同步方法，锁对象就是实现类本身也就是this
        //保证里面的n是共享的，是随时和类同步的，不能是当参数传进来的，因为传进来的不是随时和类同步的，可能三个线程同时传进来n=100，那么同步方法将失去意义
        synchronized (this) {//与同步方法等价，锁对象就是实现类本身也就是this
            if (n > 0) {
                System.out.println(Thread.currentThread().getName() + "卖了第" + n + "张票");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n--;
            }
        }
    }

    /*private static *//*synchronized*//* void fenfassss() {//方法三，静态同步方法，同时将互斥资源设置为静态，锁对象是本类的class属性，即class文件对象（反射）
        synchronized (Piao.class) {//与静态同步方法等价，锁对象是本类的class属性，即class文件对象（反射）
            if (n > 0) {
                System.out.println(Thread.currentThread().getName() + "卖了第" + n + "张票");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n--;
            }
        }
    }*/

}
