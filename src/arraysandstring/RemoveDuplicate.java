package arraysandstring;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 然后返回 nums 中唯一元素的个数。
 */
public class RemoveDuplicate {
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
        }
        return slow+1;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 3, 3, 3};
        int[] ints1 = Arrays.copyOfRange(ints, 0, removeDuplicates(ints));
        System.out.println(Arrays.toString(ints1));
    }
}
