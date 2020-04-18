package mySort;

public class XuanZe_DuiPai {
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

    public static void sort(int[] a) {
        int n = a.length - 1;
        for (int i = (n - 1) / 2; i >= 0; i--) {//调整初始堆，(n-1)/2为最后一个父节点，从下往上调整
            adjust(a, i, n);
        }
        for (int j = n; j > 0; j--) {//每次都能找到当前最大的交换到数列最后
            int temp = a[j];
            a[j] = a[0];
            a[0] = temp;
            show(a);//打印过程
            adjust(a, 0, j - 1);
        }
    }

    public static void adjust(int[] a, int start, int end) {//大顶堆，从起点开始从上到下调整堆，左孩子为2 * start + 1，右孩子为2 * start + 2.
        int temp = a[start];
        for (int i = 2 * start + 1; i <= end; i = i * 2 + 1) {//每次循环执行后i指向i的左孩子
            if (i < end && a[i] < a[i + 1]) {//右孩子数值比左孩子大
                i++;
            }
            if (temp >= a[i]) {//由于下面的树已经调整好，故根节点的两个子节点已经是下面节点中最大的，又根节点数值大于它的两个子节点，所以根节点是该树中最大的节点，故无需再调整
                break;
            } else {
                a[start] = a[i];
                start = i;          //start下移，作为下次循环的根节点，此节点数值为temp
            }
        }
        a[start] = temp;
    }
    public static void show(int[] a){
        for (int i1 : a) {
            System.out.print(i1 + " ");
        }
        System.out.println();
    }
}
