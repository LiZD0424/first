package MyE;
//泛型方法：修饰符 <M> 返回值类型（M） 函数名 （参数列表） 调用时参数列表说明类型
public class EMethod {
    public <M> void show(M m){
        System.out.println(m);
    }
    public static <S> void shows(S s){
        System.out.println(s);
    }
}
