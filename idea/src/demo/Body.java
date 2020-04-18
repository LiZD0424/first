package demo;

public class Body { //外部类修饰符只能用public 或者（default）
    private String name="外部类名字";
    public void show(){
        System.out.println("外部类方法调用");
        Heart heart=new Heart();//间接访问内部类 通过外部类方法
        heart.beat();
    }
    public void showInner(){
        int num=10;//局部内部类访问函数内局部变量，局部变量必须是final的 （事实不变就可以）因为生命周期 局部变量跟着方法在栈内存中 方法运行完就消失了 new的对象在堆中 直到垃圾回收才消失生命比栈长  故要保证堆中的num不变使其永久有效。
        class Inner{//局部内部类修饰符什么都不能写（default）
            public void show(){
                System.out.println("局部内部类"+num);
            }
        }
        Inner inner=new Inner();
        inner.show();
    }
    public class Heart{//内用外，随意访问，外用内先县创建内部类对持续性象 内部类什么修饰符都能用
        private String name="内部类名字";
        public void beat(){
            String name="局部名字";
            System.out.println("心脏跳动");
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Body.this.name);//类名.this.name
        }
    }
}
