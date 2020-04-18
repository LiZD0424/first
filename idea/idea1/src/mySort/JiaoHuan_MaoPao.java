package mySort;

import java.util.Scanner;

public class JiaoHuan_MaoPao {
    public static void main(String[] args) {
        int[] a = new int[]{8, 7, 6, 5, 4, 1, 2, 3};
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

    /*
     * 1.冒泡排序每趟排序都能确定一个数的最终位置
     * 2.当两个数相等时不需要变换前后顺序，为稳定的排序
     * */
    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {//外层循环为排序的趟数，每趟确定一个数的最终位置，故n个数最多需要n-1趟排序（元素完全逆置）
            boolean flag = false;//哨兵，监督此趟排序是否有数据交换位置，如果某一趟排序没有交换任何数据位置，则此数列已经有序，故不需要继续排序。
            //内层循环为每趟排序过程中数据的比较次数，由于每趟都能确定一个数的最终位置，故每趟数据比较次数都会比上一趟减少一次。
            //由于比较a[j]和a[j+1]大小，故n个数最大比较次数为n-1次（第1趟排序）当j=2时，若a[2]>a[3]则交换后a[2]<a[3]，即比较大的数交换到了3号位置，j++后刚好比较a[3]和a[4]大小关系，符合我们的预期，逐渐把最大的交换到数组的最后面。
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    flag = true;
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
            System.out.print("第" + (i + 1) + "趟排序：");
            for (int i1 : a) {
                System.out.print(i1 + " ");
            }
            System.out.println();
            if (!flag) {
                System.out.println("第" + (i + 1) + "趟排序无需调整");
                break;
            }
        }
    }
}
