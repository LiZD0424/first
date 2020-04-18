package rushbbbbbbb;

import java.util.Objects;

public class Bijiaodaxiao {
    public static void main(String[] args) {

    }

    public static <E extends Number & Comparable<? super E>> E bijiao(E[] e) {
        Objects.requireNonNull(e, "空指针异常");
        E min = e[0];
        for (E e1 : e) {
            if (min.compareTo(e1) > 0) {
                min = e1;
            }
        }
        return min;
    }
}
