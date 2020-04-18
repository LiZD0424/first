package MyStringBuilder;

public class MyStringBuilder {//字符串缓冲区，底层也是byte数组 但是没有被fina修饰“a”+“b”+“c”只会创建“a”“b”“c”三个串初始长度16
    public static void main(String[] args) {
        StringBuilder s1=new StringBuilder();
        StringBuilder s2= new StringBuilder("abc");//String转化为StringBuilder
        StringBuilder s3=s1.append("qwer");//StringBuilder里面sppend返回的就是调用方法的对象，故直接写就可不用定义新变量接收返回值
        String s4=s3.toString();//StringBuilder转化为String
        System.out.println(s3);
        System.out.println(s1);
    }
}
