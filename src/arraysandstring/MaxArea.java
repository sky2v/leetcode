package arraysandstring;

import java.util.Stack;

/**
 * 11.盛最多水的容器
 * 双指针+枚举
 */
public class MaxArea {

    /**
     * 谁小，谁移动
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        while (left < right) {
            res = height[right] < height[left] ?
                    Math.max(res, (right - left) * height[right--]) : Math.max(res, (right - left) * height[left++]);
        }
        return res;
    }


}
