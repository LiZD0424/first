package MyThrowable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

/*throws抛出异常给调用者，调用者必须处理这个异常，要么继续throws要么try...catch
 * 方法体内throw了多个异常，就必须在方法声明处throws多个异常，若异常有子父类关系，抛出父类异常即可
 * 父子类重写方法异常：
 * 子类重写方法的异常要小于等于父类异常（无异常最小）
 * 父类方法无异常，子类重写即时有异常也只能try...catch 不能throws
 * */
public class MyThrows {
    public static void main(String[] args) throws IOException {
        try {//可以跟多个catch 能捕获什么异常就捕获什么异常，捕获不了的向上抛
            readFile("aaa");
        } catch (FileNotFoundException e) {//从上到下执行catch，当有父子类继承关系的异常时，子类异常必须写在父类异常的上面。
             //e.getMessage();
            // e.toString();
            //e.getCause();
            e.printStackTrace();
        }finally {
            //try中有return 先保存值再执行finally语句再把保存的值返回去，为了防止catch中有return或者catch中抛异常出现的语句（不然try...catch后续代码也不会执行）
            // 尽量不让有异常的语句发生在finally块中，先用if（）判断不会产生有异常了再执行可能有异常的程序
            //finally块中有return语句时 永远运行finally中的return 应避免此类情况发生
            System.out.println("资源释放");
        }
        System.out.println("后续代码");
    }

    public static void readFile(String string) throws NullPointerException, IOException {//FileNotFoundException异常是IOException异常的子类，故抛出父类IOException异常即可
        Objects.requireNonNull(string);
        if (!string.equals("aaaa")) {
            throw new FileNotFoundException("没有找到文件");//编译时异常必须处理，要么throws要么try...catch
        }
        if (!string.endsWith(".txt")) {
            throw new IOException("文件类型不对");
        }
        System.out.println("文件读取成功");
    }
}
