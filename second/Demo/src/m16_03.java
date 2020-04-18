import java.util.Scanner;

public class m16_03 {
    public static void main(String[] args) {
        int[] s1 = new int[]{0, 0};
        int[] e1 = new int[]{1, 0};
        int[] s2 = new int[]{1, 1};
        int[] e2 = new int[]{0, -1};
        System.out.println(intersection(s1, e1, s2, e2)[0] + "," + intersection(s1, e1, s2, e2)[1]);
    }

    public static double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double k1 = (end1[1] - start1[1]) / (end1[0] - start1[0]);
        double k2 = (end2[1] - start2[1]) / (end2[0] - start2[0]);
        double[] ans = new double[2];
        ans[0] = (start2[1] - start1[1] + k1 * start1[0] - k2 * start2[0]) / (k1 - k2);
        ans[1] = (end1[1] - start1[1]) / (end1[0] - start1[0]) * (ans[0] - start1[0]) + start1[1];
        return ans;
    }
}
