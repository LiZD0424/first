package MyThread;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BaoZi {
    public static void main(String[] args) {
//        Lock lock = new ReentrantLock();
        Object object = new Object();
        new Thread() {
            @Override
            public void run() {
               /* lock.lock();
                try {
                    System.out.println("顾客说出吃什么包子和数量");
                    try {
                        lock.wait();//必须存在于同步代码块中，只能通过锁对象调用，不同的锁对应不同的wait和notify
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("包子做好了，开吃");
                } finally {
                    lock.unlock();
                }*/
                synchronized (object) {
                    System.out.println("顾客1说出吃什么包子和数量");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1包子做好了，开吃");//wait语句后面的代码等唤醒后再运行
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("顾客2说出吃什么包子和数量");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("2包子做好了，开吃");//wait语句后面的代码等唤醒后再运行
                }
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                /*try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    System.out.println("老板做包子");
                    lock.notify();
                } finally {
                    lock.unlock();
                }*/
                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (object) {
                        System.out.println("老板做包子");
                        object.notify();//随机叫醒一个线程，notifyAll叫醒全部线程
                    }
                }
            }
        }).start();
    }
}
