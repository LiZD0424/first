package MyThread;

public class Sleep extends Thread {
    public int n;
    public Sleep() {
    }

    public Sleep(String name,int n) {
        super(name);
        this.n=n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    @Override
    public void run() {
        int n=getN();
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+i);
            try {
                Thread.sleep(n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
