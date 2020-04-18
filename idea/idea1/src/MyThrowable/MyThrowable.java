package MyThrowable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*Throwable有两个子类
1.Exception
    编译时异常（写代码时候产生的异常）try...catch或throws处理
    子类RuntimeException 运行期异常
        代码编译完成后运行时产生的异常；
2.Error
    错误
    内存溢出 系统崩溃。必须修改源码
*/
public class MyThrowable {
    /*public static void main(String[] args) throws ParseException {//若是其他方法产生异常，JVM创建对应异常对象（内容，原因，位置），若没有try...catch处理异常，则向上抛给调用者，若异常一直没有处理，最终将向上抛给虚拟机 出异常直接中断 后续代码不会运行
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=simpleDateFormat.parse("1987-0808");
        System.out.println("后续代码");
    }*/
    public static void main(String[] args) {//try...catch捕获异常 后续代码可继续执行
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date=simpleDateFormat.parse("1987-0808");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("后续代码");
    }


}
