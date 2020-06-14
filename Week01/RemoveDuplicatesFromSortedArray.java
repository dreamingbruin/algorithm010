package Week01;

import Common.Pair;
import Common.Tests;

public class RemoveDuplicatesFromSortedArray {

    public static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }
            int writeIndex = findFirstDuplicateIndex(nums);
            if (writeIndex == -1) {
                return nums.length;
            }
            int readIndex = writeIndex;
            while ((readIndex = findFirstBiggerIndex(nums, readIndex + 1, nums[writeIndex - 1])) != -1) {
                nums[writeIndex] = nums[readIndex];
                writeIndex += 1;
            }
            return writeIndex;
        }

        private static int findFirstDuplicateIndex(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] <= nums[i - 1]) {
                    return i;
                }
            }
            return -1;
        }

        private static int findFirstBiggerIndex(int[] nums, int startIndex, int num) {
            for (int i = startIndex; i < nums.length; i++) {
                if (nums[i] > num) {
                    return i;
                }
            }
            return -1;
        }

    }

    public static void main(String[] args) {
        Tests.execute(Solution.class,
                new Pair<>(new int[]{1}, 1),
                new Pair<>(new int[]{1, 1}, 1),
                new Pair<>(new int[]{1, 1, 1}, 1),
                new Pair<>(new int[]{1, 1, 2}, 2),
                new Pair<>(new int[]{1, 1, 2, 3, 4, 4, 5, 6, 7, 7, 7}, 7)
        );
    }

}
