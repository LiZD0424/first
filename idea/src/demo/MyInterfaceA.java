package demo;

public interface MyInterfaceA {
    public abstract void aaa();
    public default void show(){
        System.out.println("aaa");
    }
}
