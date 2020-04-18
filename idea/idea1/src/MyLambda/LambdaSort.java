package MyLambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaSort {
    public static void main(String[] args) {
        Stu[] stus = new Stu[]{
                new Stu(1, "张三"),
                new Stu(2, "李四"),
                new Stu(3, "王五"),
                new Stu(4, "赵六")
        };
       /* Arrays.sort(stus, new Comparator<Stu>() {
            @Override
            public int compare(Stu o1, Stu o2) {
                return o2.getId()-o1.getId();
            }
        });*/
        Arrays.sort(stus,(Stu o1, Stu o2)->{//        Arrays.sort(stus, (o1, o2) -> o2.getId() - o1.getId()); 省略写法
            return o2.getId()-o1.getId();
        });
        for (Stu stu : stus) {
            System.out.println(stu);
        }
    }
}
