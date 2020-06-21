package Week02;

import Common.Pair;
import Common.Tests;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TwoSum {

    public static final class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            if (nums.length <= 1) {
                throw new IllegalArgumentException();
            }
            if (nums.length == 2 && nums[0] + nums[1] == target) {
                return new int[]{0, 1};
            }
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (map.containsKey(target - num)) {
                    return new int[]{map.get(target - num), i};
                } else {
                    map.put(num, i);
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Pair<?, ?>[] cases = {
                new Pair<>(new Object[]{new int[]{2, 7, 11, 15}, 9}, new int[]{0, 1}),
                new Pair<>(new Object[]{new int[]{-2, -7, -11, -15}, -9}, new int[]{0, 1}),
                new Pair<>(new Object[]{new int[]{3, 2, 4}, 6}, new int[]{1, 2}),
                new Pair<>(new Object[]{new int[]{0, 4, 3, 0}, 0}, new int[]{0, 3}),
                new Pair<>(new Object[]{new int[]{-1, -2, -3, -4, -5}, -8}, new int[]{2, 4})
        };
        Stream.of(Solution1.class).forEach((clazz) -> Tests.execute(clazz, cases));
    }
}
