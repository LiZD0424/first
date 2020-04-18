package FunctionalInterface;

/*
 * 函数式接口可作为方法的参数和返回值*/
public class Demo {
    public static void main(String[] args) {
        show(1, () -> "a" + "b");//Lambda表达式延后执行，他仅仅是把参数传进方法中只有满足条件（level==1）才会执行接口中的方法，才会执行字符串拼接。不用Lambda将先执行拼接再去判断，当level不等于1时就白拼接了，造成性能浪费
    }

    public static void show(int level, FunctionalInterface f) {
        if (level == 1) {
            System.out.println(f.method());
        }
    }
}
