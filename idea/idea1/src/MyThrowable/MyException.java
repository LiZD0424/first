package MyThrowable;
/*
* 自定义异常继承Exception或者RuntimeException类
* 继承Exception，编译期异常，必须处理该异常 throws或try...catch
* 继承RuntimeException，运行期异常，不需处理，默认交给JVM
* */
public class MyException extends Exception {//一般重写两个构造方法，无参构造方法和带异常信息字符串构造方法
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}
