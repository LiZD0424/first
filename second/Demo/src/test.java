import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Ccccc(className = "Stu.Stu",methodName = "eat",fieldName = "name")
public class test {
    public static void main(String[] args) throws Exception {
        Class<test> testClass = test.class;
        Ccccc annotation = testClass.getAnnotation(Ccccc.class);
        String className = annotation.className();
        String fieldName = annotation.fieldName();
        String methodName = annotation.methodName();
        Class<?> aClass = Class.forName(className);
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        Field field = aClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(o,"张三");
        Method method = aClass.getDeclaredMethod(methodName,String.class);
        method.setAccessible(true);
        method.invoke(o,"包子");
        System.out.println(o);
    }
}
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Ccccc{
    String className();
    String methodName();
    String fieldName();
}
