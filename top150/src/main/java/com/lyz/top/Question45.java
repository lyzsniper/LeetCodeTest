package com.lyz.top;

/**
 * @Auther: Jensen
 * @Date: 2025-01-05 - 01 - 05 - 2:40
 * @Description: com.lyz.top
 * @version: 1.0
 */
public class Question45 {
    class Solution {
        public int jump(int[] nums) {
            int end = 0;
            int step = 0;
            int maxPosition = 0;
            for (int i = 0; i < nums.length-1; i++) {
                maxPosition = Math.max(nums[i] + i, maxPosition);
                if (i == end) {
                   end = maxPosition;
                   step++;
                }
            }
            return step;
        }
    }
}
