package MyThrowable;

import java.util.Objects;

public class MyThrow {//立即停止程序运行 向上抛出异常,throw必须写在方法里，new的对象必须是Exception或者他的子类异常，throw出来的异常必须处理，若是RuntimeException或者是其子类异常可以不处理，默认交给JVM

    public static void main(String[] args) {
        int[] a = null;
        show(a, 3);
        System.out.println("后续代码");
    }

    private static void show(int[] a, int b) throws RuntimeException {//throws RuntimeException可以不用写
        try {//捕获了这个异常 后续代码可继续执行
            Objects.requireNonNull(a, "空指针异常");//判断参数是否是空指针，抛出空指针异常。等效于throw new NullPointerException("空指针异常");
            /*if (a == null)
                throw new NullPointerException("空指针异常");//运行期异常*/
            if (b < 0 || b > a.length - 1)
                throw new ArrayIndexOutOfBoundsException("数组索引越界");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("方法后续代码");
    }
}
