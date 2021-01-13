package com.ozygod.elementary.array;

import java.util.Arrays;

/**
 * 旋转数组
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Rotate {
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int swap = nums[start];
            nums[start] = nums[end];
            nums[end] = swap;
            start++;
            end--;
        }
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int current = i;
            int prev = nums[i];
            do {
                int next = (current+k)%nums.length;
                int tmp = nums[next];
                nums[next] = prev;
                current = next;
                prev = tmp;
                count++;
            } while (i != current);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Rotate demo = new Rotate();
        demo.rotate2(nums, 4);
        System.out.println(Arrays.toString(nums));
    }
}
