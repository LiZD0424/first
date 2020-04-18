import java.util.*;

public class M62 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(lastRemaining(n, m));
    }

    public static int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        Queue<Integer>queue=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }
        while (n>1){
            for (int i = 0; i < m-1; i++) {
                Integer poll = queue.poll();
                queue.offer(poll);

            }
            queue.poll();
            n--;
        }
        return queue.peek();
    }
}
