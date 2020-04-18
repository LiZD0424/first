package mySort;

public class ChaRu_ZhiJieChaRu {
    public static void main(String[] args) {
        int[] a = new int[]{5, 7, 6, 8, 4, 1, 2, 3};
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
        for (int i = 1; i < n; i++) {//（有序队列，无序队列）在无序队列中找一个元素插入前方有序队列中
            int temp = a[i], j = i - 1;
            while (j >= 0 && a[j] > temp) {//注意j>=0的判断在前面，不然如果在后面j=0进入循环后j--变为-1，a[-1]会出现索引越界异常ArrayIndexOutOfBoundsException
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
            show(a);
        }
    }
}
