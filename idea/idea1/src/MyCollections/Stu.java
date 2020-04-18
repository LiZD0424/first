package MyCollections;

import java.util.Objects;

public class Stu implements Comparable<Stu>{//要排序实现Comparable接口中的compareTo方法
    private int age;
    private String name;

    public Stu() {
    }

    public Stu(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stu stu = (Stu) o;
        return age == stu.age &&
                Objects.equals(name, stu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public int compareTo(Stu o) {//自己（this）减去参数就是升序
        //return 0;//返回0认为元素都是相同的
        return o.name.charAt(0)-name.charAt(0);
        //return age-o.age;
    }
}
