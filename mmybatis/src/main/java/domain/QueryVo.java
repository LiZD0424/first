package domain;

import java.util.List;

/**
 * 把实体类包装起来做查询(当有多个查询条件时把他们全都封装到queryVo一个类中)
 */
public class QueryVo {
    private User user;
    private String s;
    List<Integer> integers;
    int[]a;

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
