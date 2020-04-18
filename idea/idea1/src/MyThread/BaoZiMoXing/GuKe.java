package MyThread.BaoZiMoXing;

public class GuKe implements Runnable {
    private BaoZi baoZi;
    private int n=0;
    public GuKe(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (baoZi) {
                //while(true){
                if (baoZi.flag == true) {
                    System.out.println(n);
                    System.out.println("开吃");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("吃完了,叫醒老板生产包子");
                    baoZi.flag=false;
                    baoZi.notify();
                } else {
                    System.out.println(n);
                    System.out.println("没包子。等待");
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                n++;
            }//}
        }
    }
}
