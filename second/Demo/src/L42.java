import java.util.Stack;

public class L42 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(a));
    }

    public static int trap(int[] height) {
        if (height.length < 3)
            return 0;
        int[] stack = new int[height.length];
        int ans = 0, t = -1;
        for (int i = 0; i < height.length; i++) {
            while (t != -1 && height[stack[t]] < height[i]) {
                int h = stack[t--];
                while (t != -1 && stack[t] == h) {//一次只去掉相等的一层
                    t--;
                }
                if (t != -1) {//有可能左边的一直比现在的柱子低，所以可能会导致栈空，意味着左边不回剩水。
                    int top = stack[t];
                    if (height[i] < height[top]) {
                        ans += (height[i] - height[h]) * (i - top - 1);
                    } else {
                        ans += (height[top] - height[h]) * (i - top - 1);
                    }
                    // ans += (Math.min(height[i], height[top]) - height[h]) * (i - top - 1);//每去掉一层计算一次雨水面积
                }
            }
            stack[++t] = i;
        }
        return ans;
    }
}
