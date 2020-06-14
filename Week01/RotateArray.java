package Week01;

import Common.Pair;
import Common.Tests;

public class RotateArray {

    public static class Solution {
        public void rotate(int[] nums, int k) {
            if (nums.length <= 1 || k <= 0) {
                return;
            }
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            int temp;
            while (start < end) {
                temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start += 1;
                end -= 1;
            }
        }
    }

    public static void main(String[] args) {
        Tests.execute(Solution.class,
                new Pair<>(new Object[]{
                        new int[]{1},
                        3
                }, new int[]{1}),
                new Pair<>(new Object[]{
                        new int[]{1},
                        0
                }, new int[]{1}),
                new Pair<>(new Object[]{
                        new int[]{1, 2},
                        3
                }, new int[]{2, 1}),
                new Pair<>(new Object[]{
                        new int[]{1, 2, 3, 4, 5, 6, 7},
                        3
                }, new int[]{5, 6, 7, 1, 2, 3, 4})
        );
    }
}
