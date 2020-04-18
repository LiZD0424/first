package MyThread;

public class Interrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("线程执行");
        });
        thread.start();
        thread.interrupt();
        System.out.println("自定义线程"+thread.isInterrupted());
        System.out.println("main线程"+Thread.currentThread().isInterrupted());
    }
}
