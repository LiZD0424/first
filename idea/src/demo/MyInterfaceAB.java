package demo;

public interface MyInterfaceAB extends MyInterfaceA,MyInterfaceB{
    @Override
    default void show() {//接口有重复的抽象方法aaa()没关系，实现时只需实现一次；接口中有重复的默认方法show()必须重写同时必须用default修饰
        System.out.println("ababab");
    }

}
