import java.util.Scanner;

public class L945 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] A = new int[111];
        int[]b=new int[10];
        int n = 0;
        int num=0;
        while (!scanner.hasNext("a")) {
            A[n++] = scanner.nextInt();
        }
        for (int j = 0; j < n; ++j) {
            b[A[j]]++;
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i]>1){
                int k=b[i]-1;
                b[i+1]+=k;
                num+=k;
            }
        }
        System.out.println(num);
    }
}
