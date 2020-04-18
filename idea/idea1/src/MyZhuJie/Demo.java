package MyZhuJie;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@KuangJia(className ="FanShe.Person",methodName = "eat")
public class Demo {
    public static void main(String[] args) throws Exception {
        Class cls=Demo.class;
     /*   Class<?> aClass = Class.forName("MyZhuJie.Demo");
        KuangJia annotation1 = aClass.getAnnotation(KuangJia.class);
        String s = annotation1.className();*/
        Annotation annotation = cls.getAnnotation(KuangJia.class);//相当于创建了一个KuangJia接口的实现类对象an
        String className=((KuangJia)annotation).className();
        String methodName=((KuangJia)annotation).methodName();
        Class c=Class.forName(className);
        Object o=c.newInstance();
        Method method=c.getMethod(methodName);
        method.invoke(o);
    }
}
