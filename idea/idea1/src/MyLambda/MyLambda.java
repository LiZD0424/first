package MyLambda;

/*
 * 面向对象编程：若想做一件事情，想找到能做这件事的对象，调用对象的方法，完成事情
 * 函数式变成思想：只要能获取结果，谁去做的怎么做的不关心。重视结果不重视过程
 * 有且仅有一个抽象方法的接口称为函数式接口
 *
 * 使用Lambda必须是（new 接口）的场景且接口中有且仅有一个抽象方法，方法的（参数）或（局部变量）类型必须是Lambda对应接口的类型，才能使用Lambda作为接口的实例
 * Lambda表达式标准格式
 * （参数列表）->{ 重写的方法体 }
 *
 * 可省略写法
 * 凡根据上下文能推到出来的内容可省略不写
 * 1.（参数列表） 数据类型可省略不写
 * 2.（参数列表） 如果参数只有一个，参数数据类型和（）都可不写
 * 3.{ 一些代码 } 如果{ }中的代码只有一行，无论是否有返回值。都可以把{ }，return，分号 一起省略
 * */
public class MyLambda {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程创建");
            }
        }).start();
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "线程创建")).start();

        new Cook() {
            @Override
            public void food() {
                System.out.println("做饭");
            }
        }.food();
        show(()->{
            System.out.println("chifan");
        });
        Cook cook= () -> System.out.println("zuofan1");
        cook.food();
        //() -> {System.out.println("zuofan1");}.food不对
    }
    public static void show(Cook cook){
        cook.food();
    }
}
