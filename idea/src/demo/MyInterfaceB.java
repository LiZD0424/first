package demo;

public interface MyInterfaceB {
    public abstract void aaa();
    public default void show(){
        System.out.println("bbb");
    }
}
