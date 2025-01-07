package com.lyz.top.greedy;

/**
 * @Auther: Jensen
 * @Date: 2025-01-05 - 01 - 05 - 2:40
 * @Description: com.lyz.top
 * @version: 1.0
 */
public class Question55 {
    class Solution {
        public boolean canJump(int[] nums) {
            int maxIndex = 0;
            for (int i = 0; i < nums.length-1; i++) {
                if (i <= maxIndex) {
                    if (i+nums[i] > maxIndex) {
                        maxIndex = i + nums[i];
                    }
                }
            }
            if (maxIndex >= nums.length-1) {
                return true;
            } else {
                return false;
            }
        }
    }
}
