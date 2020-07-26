package Week05;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution2 {

    public int canJump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        return bfs(nums);
    }

    private int bfs(int[] nums) {
        int min = Integer.MAX_VALUE;
        int jumped = 0;
        Set<Integer> accessedIndex = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(-1);
        boolean sign = false;
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            if (index == -1) {
                if (!sign) {
                    sign = true;
                    jumped += 1;
                    queue.offer(-1);
                    continue;
                } else {
                    break;
                }
            }
            sign = false;
            int maxStep = nums[index];
            if (index + maxStep >= nums.length - 1) {
                min = Math.min(min, jumped + 1);
                continue;
            }
            for (int i = 1; i <= maxStep; i++) {
                int nextIndex = Math.min(index + i, nums.length - 1);
                if (!accessedIndex.contains(nextIndex)) {
                    accessedIndex.add(nextIndex);
                    queue.offer(nextIndex);
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution2().canJump(new int[]{1, 2, 0, 1, 1, 0, 2, 0, 0, 0, 0}));
        System.out.println(new Solution2().canJump(new int[]{1, 0, 0}));
        int[] ints = new int[10000];
        for (int i = 0; i < 10000; i++) {
            ints[i] = 1;
        }
        System.out.println(new Solution2().canJump(ints));
    }

}
