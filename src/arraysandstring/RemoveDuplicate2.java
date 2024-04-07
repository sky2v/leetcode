package arraysandstring;


import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicate2 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = 0;
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 2] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 3, 3, 3};
        int[] ints1 = Arrays.copyOfRange(ints, 0, removeDuplicates(ints));
        System.out.println(Arrays.toString(ints1));
    }
}
