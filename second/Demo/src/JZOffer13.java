import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class JZOffer13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(movingCount(m, n, k));

    }

    public static int movingCount(int m, int n, int k) {
        int[] X = new int[]{0, 0, -1, 1};
        int[] Y = new int[]{-1, 1, 0, 0};
        int ans = 1;
        Queue<int[]> ints = new ArrayDeque<>();
        int[][]flag=new int[m][n];
        flag[0][0]=1;
        ints.offer(new int[]{0, 0});
        while (!ints.isEmpty()) {
            int[] poll = ints.poll();
            int x = poll[0], y = poll[1];

            for (int i = 0; i < 4; i++) {
                int x3 = x + X[i];
                int y3 = y + Y[i];
                int x1 = x3 / 10, x2 = x3 % 10, y1 = y3 / 10, y2 = y3 % 10;
                if (x3 < 0 || x3 >= m || y3 < 0 || y3 >= n ||flag[x3][y3]!=0|| x1 + x2 + y1 + y2 > k) {
                    continue;
                }
                ints.offer(new int[]{x3, y3});
                flag[x3][y3]=1;
                ans++;
                System.out.println(x3+","+y3);
                System.out.println();
            }
        }
        return ans;
    }
}
