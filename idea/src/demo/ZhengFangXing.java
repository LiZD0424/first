package demo;

public class ZhengFangXing extends TuXing {
    public ZhengFangXing() {
        System.out.println("子类构造方法执行");
    }

    @Override
    public int mianJi() {
        return 1;
    }
}
