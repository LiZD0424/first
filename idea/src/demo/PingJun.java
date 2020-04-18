package demo;

import java.util.ArrayList;
import java.util.List;

public class PingJun implements FenFa {

    @Override
    public List<Integer> list(int m, int n) {
        List<Integer> list=new ArrayList<>();
        int a=m/n;
        int b=m%n;
        for (int i = 0; i < n-1; i++) {
            list.add(a);
        }
        list.add(a+b);
        return list;
    }
}
