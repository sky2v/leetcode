package other;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Code05_MergeSor {


    public static int[] generateRandomArrays(int maxSize, int maxValue) {
        int[] ints = new int[((int) ((maxSize + 1) * Math.random()))];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = ((int) ((maxValue + 1) * Math.random()));
        }
        return ints;
    }


    /**
     * 1.如果输入内只有一个元素，则直接返回，否则将长度为 n 的输入序列分成两个长度为 n/2 的子序列；
     * 2.分别对这两个子序列进行归并排序，使子序列变为有序状态；
     * 3.设定两个指针，分别指向两个已经排序子序列的起始位置；
     * 4.比较两个指针所指向的元素，选择相对小的元素放入到合并空间（用于存放排序结果），并移动指针到下一位置；
     * 5.重复步骤 3 ~ 4 直到某一指针达到序列尾；
     * 6.将另一序列剩下的所有元素直接复制到合并序列尾。
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
//        执行归并排序
        process(arr, 0, arr.length-1);
    }

    public static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }

        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge2(arr, l, mid, r);

    }

    /**
     * 合并
     * 多次循环 需要优化
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    public static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
//        双指针
        int i = 0;
        int pl = l;
        int pr = mid+1;

        while (pl <= mid && pr <= r) {
            help[i++] = arr[pl] <= arr[pr] ? arr[pl++] : arr[pr++];
        }

        while (pl <= mid) {
            help[i++] = arr[pl++];
        }

        while (pr <= r) {
            help[i++] = arr[pr++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
    }


    /**
     * 优化merge函数，去除多余的循环
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    public static void merge2(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int pl = l;
        int pr = mid+1;
        for (int j = 0; j < help.length; j++) {
            if (pl <= mid && pr<=r) {
                help[i++] = arr[pl] < arr[pr] ? arr[pl++] : arr[pr++];
            } else if (pl <= mid) {
                help[i++] = arr[pl++];
            } else{
                help[i++] = arr[pr++];
            }
        }

        for (int num : help) {
            arr[l++] = num;
        }

    }

    public static void main(String[] args) {
        int[] arr = generateRandomArrays(10, 10);
        System.out.println("排序前：" + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
