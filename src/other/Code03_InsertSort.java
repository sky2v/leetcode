package other;

import java.util.Arrays;

public class Code03_InsertSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int end = i; (end > 0) && (arr[end] < arr[end - 1]); end--) {
                swap(arr, end, end - 1);
            }
        }
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] ints = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) ((maxValue + 1) * Math.random());
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = generateRandomArray(10, 10);
        System.out.println("排序前：" + Arrays.toString(ints));
        insertSort(ints);
        System.out.println("排序后：" + Arrays.toString(ints));
    }

}
