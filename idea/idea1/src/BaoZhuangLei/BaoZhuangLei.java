package BaoZhuangLei;

public class BaoZhuangLei {//自动装箱拆箱1.ArrayList<Integer> 取数添加数2.包装类对象直接加减等运算
    public static void main(String[] args) {
        //基本类型转包装类(装箱)
        Integer in1=new Integer(1);//int
        Integer in2=new Integer("1");//String 必须全部由数字构成
        Integer in3=Integer.valueOf(1);
        Integer in4=Integer.valueOf("1");
        //拆箱
        int a=in1.intValue();
        double b=in2.doubleValue();
        //基本类型转为字符串
        String str1=a+"";//推荐
        String str2=Integer.toString(1);//int
        String str3=String.valueOf(1);
        System.out.println(str1+str2+str3);
        //字符串转基本类型
        int c=Integer.parseInt(str1);
    }
}
