package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SuiJi implements FenFa {
    @Override
    public List<Integer> list(int m, int n) {
        List<Integer> list=new ArrayList<>();
        int n1=n;
        int m1=m;
        for (int i = 0; i < n-1; i++) {
            Random r=new Random();
            int k=r.nextInt(m1-n1)+1;
            list.add(k);
            n1--;
            m1-=k;
        }
        list.add(m1);
        return list;
    }
}
