package MyThread.BaoZiMoXing;
/*
* 锁对象：包子类对象
* 包子类：状态（是否有包子）
* 包子铺类：
* 包子状态：true 调用wait等待
*           false 做包子，包子状态改为true，唤醒顾客线程
* 顾客类：
* 包子状态：true 开吃，吃完唤醒包子铺
*           false 调用wait等待
*  顾客占有包子锁（包子铺没锁不能执行），没包子等待，顾客自己阻塞让出锁-》包子铺得到锁执行执行 -》 没包子，做包子唤醒顾客（顾客没锁不能执行）-》循环到有包子，包子铺自己阻塞（让出锁）-》顾客得到锁执行-》有包子，吃完唤醒包子铺（包子铺没锁不能执行）-》循环到没包子，顾客自己阻塞（让出锁）-》包子铺得到锁执行
* 线程被唤醒后不会立即执行，会到阻塞队列里竞争锁和cpu，直到当前运行进程放弃cpu和锁之后再运行刚刚被唤醒的进程
* */
public class Main {
    public static void main(String[] args) {
        BaoZi baoZi=new BaoZi();
        Runnable r1=new BaoZiPu(baoZi);
        Runnable r2=new GuKe(baoZi);
        new Thread(r2).start();
        new Thread(r1).start();
    }
}
