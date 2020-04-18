package MyE;
//含有泛型的类实现方法2.继续使用泛型 实现类名 <I> implement 接口名<I>此处不指定类型，在创建对象时指定
public class MyInterfaceImpl2<I> implements MyInterface<I>{
    @Override
    public void show(I i) {
        System.out.println(i);
    }
}
