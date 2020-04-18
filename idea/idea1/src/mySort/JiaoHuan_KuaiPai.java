package mySort;

public class JiaoHuan_KuaiPai {
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

    public static int[] sort(int[] a) {
        swap(a, 0, a.length - 1);
        return a;
    }

    public static int[] swap(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int temp = a[low];
        while (low < high) {//不用带等号，带等号最后一次进入循环相当于什么都没做
            while (a[high] > temp && low < high) {//时刻都要注意low<high条件，防止重复交换，注意不能带等号，如果带等号出循环不是low=high而是low>high，这时交换数值违反逻辑
                high--;
            }
            a[low] = a[high];//即使相等也要交换数值，这也是快排不稳定的原因
            while (a[low] < temp && low < high) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;//中轴归位
        show(a);//打印中间过程
        if (start < low) {//如果中轴左边还有数，递归排序左边
            swap(a, start, low - 1);
        }
        if (end > low) {//如果中轴右边还有数，递归排序右边
            swap(a, low + 1, end);
        }
        return a;
    }
    public static void show(int[] a){
        for (int i1 : a) {
            System.out.print(i1 + " ");
        }
        System.out.println();
    }
}
