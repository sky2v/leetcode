package other;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Code04_quickSort {

    public static void swap(int[] arr, int i, int j) {
        if (arr == null || arr.length < 2) {
            return;
        }
    }


    public static void quickSort(int[] arr, int low, int high) {
        if ((arr == null || arr.length < 2) || (low >= high)) {
            return;
        }

        int partition = partition(arr, low, high);
        quickSort(arr, low, partition - 1);
        quickSort(arr, partition + 1, high);
    }

    public static int partition(int[] array, int low, int high) {
        // 取最后一个元素作为中心元素
        int pivot = array[high];
        // 定义指向比中心元素大的指针，首先指向第一个元素
        int pointer = low;
        // 遍历数组中的所有元素，将比中心元素大的放在右边，比中心元素小的放在左边
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                // 将比中心元素小的元素和指针指向的元素交换位置
                // 如果第一个元素比中心元素小，这里就是自己和自己交换位置，指针和索引都向下一位移动
                // 如果元素比中心元素大，索引向下移动，指针指向这个较大的元素，直到找到比中心元素小的元素，并交换位置，指针向下移动
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
        }
        // 将中心元素和指针指向的元素交换位置
        int temp = array[pointer];
        array[pointer] = array[high];
        array[high] = temp;
        return pointer;
    }

    public static int[] generateRandomArrays(int maxSize, int maxValue) {
        int[] ints = new int[((int) ((maxSize + 1) * Math.random()))];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = ((int) ((maxValue + 1) * Math.random()));
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = generateRandomArrays(10, 10);
        System.out.println("排序前：" + Arrays.toString(ints));
        quickSort(ints, 0, ints.length - 1);
        System.out.println("排序后：" + Arrays.toString(ints));

    }
}
