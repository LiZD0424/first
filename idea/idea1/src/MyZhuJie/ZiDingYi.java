package MyZhuJie;

import java.lang.annotation.*;

//自定义注解public @interface 注解名称{}
//注解本质就是接口 默认继承Annotation接口
//public interface ZiDingYi extends java.lang.annotation.Annotation{}
//属性（接口中的成员方法）
/*1.属性的返回值类型
 *       基本数据类型，String，枚举，注解，以上类型的数组（void不可以）
 * 2.在使用的时候需要给属性赋值
 *       如果只有一个属性需要赋值且属性名称为value，则value=可以不写 ，直接写值
 * */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})//既能用于类上，也能用于方法上，还能用于成员变量上
@Inherited//使用该注解的父类，子类继承它时不用再标注此注解，也会自动继承父类的注解
@Retention(RetentionPolicy.RUNTIME)//注解保存到JVM虚拟机上；SOURCE保存到源码，不会保存到字节码文件中；CLASS保存到字节码文件，不会保存到JVM中
@Documented //会被抽取到API文档中
public @interface ZiDingYi {
    /*    int age();
        String name()default "张三";//使用时不赋值默认张三*/
    int value();
}
