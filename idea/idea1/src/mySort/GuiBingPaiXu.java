package mySort;

public class GuiBingPaiXu {
    public static void main(String[] args) {
        int[] a = new int[]{5, 7, 6, 8, 4, 2, 1, 3, 2};
        System.out.print("原数列：");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        sort(a, 0, a.length - 1);
        System.out.print("排序后序列：");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void show(int[] a) {
        for (int i1 : a) {
            System.out.print(i1 + " ");
        }
        System.out.println();
    }

    public static void sort(int[] a, int start, int end) {
        if (start >= end)
            return;
        int center = (start + end) >> 1;
        sort(a, start, center);
        sort(a, center + 1, end);
        merge(a, start, center, end);
    }

    public static void merge(int[] a, int start, int center, int end) {
        int[] temp = new int[a.length];//辅助数组
        int t = start, i = start, j = center + 1;//i为左半边开头，j为右半边开头，t为辅助数组工作部分开头
        while (i <= center && j <= end) {//按顺序归并
            if (a[i] < a[j]) {
                temp[t++] = a[i++];
            } else {
                temp[t++] = a[j++];
            }
        }
        while (j <= end) {//剩余部分直接拷贝
            temp[t++] = a[j++];
        }
        while (i <= center) {//同上
            temp[t++] = a[i++];
        }
        for (int i1 = start; i1 <= end; i1++) {//将这次归并影响的部分拷贝回原数组
            a[i1] = temp[i1];
        }
        show(a);
    }
}
