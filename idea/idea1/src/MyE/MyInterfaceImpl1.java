package MyE;
//含有泛型的类实现方法1.在实现类中规定泛型类型 实现类名 （不写<I>）implements 接口名<指定类型>
public class MyInterfaceImpl1 implements MyInterface<String> {
    @Override
    public void show(String s) {
        System.out.println(s);
    }
}
