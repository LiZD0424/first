import java.util.Scanner;

public class L887 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(superEggDrop(k, n));
    }

    public static int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }
        for (int i = 2; i <= N; i++) {
            dp[1][i] = i;
            dp[0][i] = 0;
        }

        for (int i = 2; i <= K; i++) {
            int start = 1;
            for (int j = 2; j <= N; j++) {
                int lo = start, hi = j;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp[i - 1][x - 1];
                    int t2 = dp[i][j - x];

                    if (t1 < t2)
                        lo = x;
                    else if (t1 > t2)
                        hi = x;
                    else
                        lo = hi = x;
                }
                /*dp[i][j] = 1 + Math.min(Math.max(dp[i - 1][lo - 1], dp[i][j - lo]),
                        Math.max(dp[i - 1][hi - 1], dp[i][j - hi]));*/
                if (Math.max(dp[i - 1][lo - 1], dp[i][j - lo]) <= Math.max(dp[i - 1][hi - 1], dp[i][j - hi])) {
                    dp[i][j] = 1 + Math.max(dp[i - 1][lo - 1], dp[i][j - lo]);
                    start = lo;
                } else {
                    dp[i][j] = 1 + Math.max(dp[i - 1][hi - 1], dp[i][j - hi]);
                    start = hi;
                }
            }
        }
        return dp[K][N];
    }
}
