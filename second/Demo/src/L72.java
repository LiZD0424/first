import java.util.Scanner;

public class L72 {
    public static void main(String[] args) {
        String a = new Scanner(System.in).next();
        String b = new Scanner(System.in).next();
        System.out.println(minDistance(a, b));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        if (m == 0)
            return n;
        else if (n == 0)
            return m;
        else {
            for (int i = 0; i < m+1; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i < n+1; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
    }
}
