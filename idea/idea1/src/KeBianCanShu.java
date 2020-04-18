public class KeBianCanShu {
    public static void main(String[] args) {
        System.out.println(ssum("求和为","ssss",2,3,4,5,6));
    }

    public static int ssum(String s, Object... obj) {//参数列表中只能有一个可变参数且只能在参数列表的最后。可以是0个参数底层是0个元素的数组
        System.out.println(s + obj[2]);
        int sum = 0;
        for (int i = 1; i < obj.length; i++) {
            String a=obj[i].toString();
           // System.out.println(a);
            sum += Integer.parseInt(a) ;
        }
        return sum;
    }
}
