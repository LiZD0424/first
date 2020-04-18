package FanShe;

public class Person {
    private String name;
    private int id;

    public String a;
    protected String b;
    String c;
    private String d;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public Person() {
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void eat(){
        System.out.println("eat ....");
    }

    public void eat(String s){
        System.out.println("eat "+s+" ...");
    }
}
