package mySort;

public class XuanZe_JianDanXuanZe {
    public static void main(String[] args) {
        int[] a = new int[]{5, 7, 6, 8, 4, 1, 2, 3, 3};
        System.out.print("原数列：");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        sort(a);
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

    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {//每趟排序找到待排序列中的最小值与待排序列头交换
            int min = i;//记录待排序数组内的最小值下标
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];//因为待排队头元素直接和待排最小元素交换顺序，所以不稳定。数组实现的简单选择排序是不稳定的，链表实现的选择排序是稳定的，因为只是把最小元素节点链接到待排序列头，并没有交换链表节点
            a[i] = a[min];
            a[min] = temp;
            show(a);
        }
    }
}
