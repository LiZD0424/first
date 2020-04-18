package demo;

public final class FinalClass {//一个类如果是final类 不能被继承 其成员函数不能被重写
    public final void show(){// final类不能被重写 与abstract矛盾abstract必须被实现（重写）
        System.out.println("final方法执行");
    }
    final int a=100;//成员变量 基本数据类型加final时其值不能发生改变，只能赋值一次故只能在定义出赋值，不然系统调用默认构造方法给他赋默认值就不能继续复赋值了，或者定义处不赋值但保证所有构造方法里都对此成员变量进行了赋值
    //a=200;//错误
    Student student=new Student(true,"李子东1");//引用数据类型加final时期地址不能改变 地址里面的内容可以改变
    public void showStu(){
        System.out.println(student.getName()+a);
    }

    public int getA() {
        return a;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
