import java.util.Scanner;

public class L1111 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] a = work(s);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static int[] work(String s) {
        int[] e = new int[s.length()];
        int a=0,b=0,i=0;
        for (char c : s.toCharArray()) {
            if(c=='('){
                if (a<=b){
                    e[i++]=0;
                    a++;
                }else {
                    e[i++]=1;
                    b++;
                }
            }else {
                if (a>b){
                    e[i++]=0;
                    a--;
                }else {
                    e[i++]=1;
                    b--;
                }
            }
        }
        return e;
    }
}
