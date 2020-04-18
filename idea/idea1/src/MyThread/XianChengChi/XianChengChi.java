package MyThread.XianChengChi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 线程池解决需要重复创建销毁线程的问题
* 线程创建后不会马上销毁，以便继续执行其他任务
*
* */
public class  XianChengChi {
    public static void main(String[] args) {
        ExecutorService ex=Executors.newFixedThreadPool(2);//创建指定线程个数的线程池，返回ExecutorService的实现类对象
        ex.submit(new RunnableImpl());//执行任务 参数为Runnable接口的实现类对象
        ex.submit(new RunnableImpl());
        ex.submit(new RunnableImpl());
        ex.shutdown();//销毁线程池（不建议使用）之后就不能在使用此线程池了
    }
}
