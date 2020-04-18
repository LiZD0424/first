package Stu;

public class Stu {
    private String name;
    private void eat(String s){
        System.out.println("eat"+s);
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                '}';
    }
}
