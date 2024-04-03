package other;

import java.util.Arrays;

/**
 * 分治算法思想
 */
public class Code09_BinarySearch {

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] ints = new int[((int) ((maxSize + 1) * Math.random()))];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = ((int) ((maxValue + 1) * Math.random()));
        }
        return ints;
    }


    public static int binarySearch(int[] arr, int start, int end, int entry) {

        if (arr == null || start > end) {
            return -1;
        }
        int mid = start + ((end - start) >> 1);
        if (arr[mid] == entry) return mid;
        else if (arr[mid] > entry) {
            return binarySearch(arr, start, mid - 1, entry);
        }else {
            return binarySearch(arr, mid + 1, end, entry);
        }
    }

    public static void main(String[] args) {
        int testting = 10;
        for (int j = 0; j < testting; j++) {
            int[] ints = generateRandomArray(10, 10);
//        int[] ints = new int[]{5};
            System.out.println("数组：" + Arrays.toString(ints));
            Code04_quickSort.quickSort(ints, 0, ints.length - 1);
            int i = binarySearch(ints, 0, ints.length - 1, 1);
            if (i > 0) {
                System.out.println("找到了，索引位置：" + i + "值：" + ints[i]);
            }else {
                System.out.println("没找到");
            }
        }

    }

}
