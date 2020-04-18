package MyThread.BaoZiMoXing;

public class BaoZiPu implements Runnable {
    private BaoZi baoZi;

    public BaoZiPu(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
       while (true) {
            synchronized (baoZi) {
               // while(true){
                if (baoZi.flag == false) {
                    System.out.println("生产包子");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("包子做好了");
                    baoZi.flag = true;
                    baoZi.notify();
                }else {
                    System.out.println("还有包子。不用做");
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("*****************************");
            }//}
        }
    }
}
