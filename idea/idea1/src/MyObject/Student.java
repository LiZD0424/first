package MyObject;

import java.util.Objects;

public class Student {
    private int id;
    private String name;
    public static int banJi;
    private static int idCount = 0;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

   /* @Override
    public boolean equals(Object o) {//不重写this==o 比较地址值（引用型）
        if (o==null){
            return false;
        }else if (o==this){
            return true;
        } else if (o instanceof Student) {
            Student stu = (Student) o;//多态写法，不能直接访问子类成员变量，必须向下转型
            return this.name.equals(stu.name);//this是谁调用的此函数。
        }else {
        return false;
        }
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);//Objects类里面的equals容忍空指针 return (a == b) || (a != null && a.equals(b));当空指针null.equals时不会报错返回false
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Student(String name) {
            this.name = name;
            this.id = ++idCount;
        }

        public int getId () {
            return id;
        }

        public void setId ( int id){
            this.id = id;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }
    }
