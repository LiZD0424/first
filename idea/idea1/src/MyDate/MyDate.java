package MyDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MyDate {
    public static void main(String[] args) throws ParseException {
        /*String birthDay=new Scanner(System.in).next();
        SimpleDateFormat birth=new SimpleDateFormat("yyyy-MM-dd");//SimpleDateFormat是抽象类DateFormat的子类实现了其中的抽象方法 创建指定格式的对象
        Date b=new Date();//无参构造方法根据当前时间创建日期对象
        Date a=new Date(1582796312945L);//返回自 1970 年 1 月 1 日 00:00:00 GMT经过long型参数毫秒值以后的时间
        System.out.println(b);
        System.out.println(b.getTime());//返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的long型毫秒数。
        System.out.println(a);
        String text=birth.format(b);//将Date类型的参数转化为指定类型的字符串（格式化）
        System.out.println(text);
        Date c= birth.parse(birthDay);//将指定格式的字符串转化为date型（格式化解析）
        long time=b.getTime();
        long time1 = c.getTime();
        long time2=time-time1;
        System.out.println(time2/1000/60/60/24);*/
        long s = System.currentTimeMillis();//获取系统当前时间 毫秒 一般用于测试程序运行时间
        Calendar calendar = Calendar.getInstance();//多态实际上是Calendar类的静态方法getInstance创建了他的子类GregorianCalendar对象并返回子类对象。大体等同于下面的写法
        Calendar calendar1 = new GregorianCalendar();
        System.out.println(calendar);
        System.out.println(calendar1);
        long e = System.currentTimeMillis();//获取系统当前时间 毫秒
        System.out.println("程序耗时" + (e - s));
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8, 9, 10};
        System.arraycopy(a, 1, b, 1, 3);//数组复制 参数（原数组引用，复制起始位置，待复制数组引用，替换起始位置，复制长度）
        for (int i : b) {
            System.out.println(i);
        }
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
