import java.util.Scanner;

public class L8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        boolean f = false;
        int i = 0, n = s.length(), ans = 0;
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            f = true;
            i++;
        } else if (!Character.isDigit(s.charAt(i))) {
            return 0;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            int t = s.charAt(i) - '0';
            if (ans > (Integer.MAX_VALUE - t) / 10) {
                if (f) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            ans = ans * 10 + t;
            i++;
        }
        if (f) {
            return -ans;
        }
        return ans;
    }
}
