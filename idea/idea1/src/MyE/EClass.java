package MyE;
//含有泛型的类 类名<E> 创建时说明类型
public class EClass<E> {
    private int id;
    private E name;

    public EClass() {
    }

    public EClass(int id, E name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EClass{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
