package MyThread.XianChengChi;

public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程执行");
    }
}
