package FanShe;

import MyCollections.Stu;
import MyThread.Per;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/*
* 不修改该类任何代码，可以创建任意类对象，可以执行任意类方法*/
public class Text {
    public static void main(String[] args) throws Exception {
        Properties properties=new Properties();
        ClassLoader classLoader= Text.class.getClassLoader();//根据同工程内的一个类，获取类的类加载器,既然类加载器能找到类，就也能找到同在此工程下的配置文件
        InputStream is = classLoader.getResourceAsStream("pro.properties");//找到此文件并返回它的字节输入流
        properties.load(is);
        String className=properties.getProperty("className");
        String methodName=properties.getProperty("methodName");
        //String parameterTypes=properties.getProperty("parameterTypes");

        //加载该类进内存
        Class<?> cls=Class.forName(className);//找到该类名的class对象
        Constructor c=cls.getConstructor();//获取该类的构造方法
        Object o = c.newInstance();//创建一个该类的对象
        Method method=cls.getMethod(methodName);//获取该类的一个方法
        method.invoke(o);//运行该对象的方法
    }


}
