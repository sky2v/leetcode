package other;

import java.util.Arrays;

public class Code01_BubbleSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int end = arr.length-1; end > 0; end--) {
            for (int j = 0; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }

        }
    }

    public static int[] generateRandomArray(int maxSize /*最大长度,可以小于*/, int maxValue) {
        // Math.random() [0,1)
        // Math.random() * N [0,N)
        // (int)(Math.random() * N) [0, N-1]
        int[] arr = new int[(int) (maxSize * Math.random() + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return arr;

    }

    public static void main(String[] args) {
        int[] ints = generateRandomArray(10, 10);
        System.out.println("排序前:" + Arrays.toString(ints));
        bubbleSort(ints);
        System.out.println("排序后:" + Arrays.toString(ints));

    }
}
