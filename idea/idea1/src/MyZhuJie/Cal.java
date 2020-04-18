package MyZhuJie;

public class Cal {
    @Check//加上Check的方法将会被测试
    public int add(int a,int b){
        return a+b;
    }
    @Check
    public int sub(int a,int b){
        return a-b;
    }
    @Check
    public int div(int a,int b){
        return a/b;
    }
    @Check
    public void show(int a,int b){
        System.out.println("show");
    }
}
