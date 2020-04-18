package mySort;

public class ChaRu_XiEr {
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
        int dk = a.length / 3 + 1;
        while (dk > 1) {
            shell(a, dk);
            dk = dk / 3 + 1;
        }
        shell(a, 1);//增量缩小到1后，再进行一次排序即可得到正确排序的序列。
    }

    public static void shell(int[] a, int dk) {
        for (int i = dk; i < a.length; i++) {//希尔排序就是将直接插入排序的增量从1变为dk
            int temp = a[i], j = i - dk;
            while (j >= 0 && temp < a[j]) {
                a[j + dk] = a[j];
                j -= dk;
            }
            a[j + dk] = temp;
        }
        show(a);
    }
}
