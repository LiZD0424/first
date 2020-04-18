package MyThread;

/*多线程实现方法1.继承Thread类 重写其中的run（）方法
 * 在主函数创建对象，并调用对象名.start方法 会运行类中的run（）方法
 * 一个线程只能启动一次，当线程结束后不能重复执行
 *可设置优先级，优先级一样则随机运行
 * */
public class Per extends Thread {
    @Override
    public void run() {
       // System.out.println(super.getName());
        Thread thread = Thread.currentThread();//返回正在执行线程的引用，此引用相当于this
        //System.out.println(thread);
        String name = thread.getName();
        System.out.println(name);
       /* for (int i = 0; i < 10; i++) {
            System.out.println("run:" + i);
        }*/
    }

    public Per() {
    }

    public Per(String name) {
        super(name);
    }
}
