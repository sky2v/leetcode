package arraysandstring;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class RotateArrays {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) {
            return;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[(k + i) % nums.length] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, nums.length);

    }

    /**
     * 反转两遍数组
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
