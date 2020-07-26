package Week05;

import java.util.*;

public class Solution1 {

    private final Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<Integer> numList = new ArrayList<>(nums.length);
        for (int num : nums) {
            numList.add(num);
        }
        for (int i = 0; i < numList.size(); i++) {
            dfs(numList, i, 4, target, new ArrayList<>());
        }
        return new ArrayList<>(set);
    }

    private void dfs(List<Integer> numList, int index, int count, int target, List<Integer> resultList) {
        if (count == 1) {
            for (int i = index; i < numList.size(); i++) {
                Integer num = numList.get(i);
                if (target == num) {
                    resultList.add(target);
                    Collections.sort(resultList);
                    set.add(resultList);
                }
            }
            return;
        }
        int me = numList.get(index);
        for (int i = index + 1; i < numList.size(); i++) {
            ArrayList<Integer> newResultList = new ArrayList<>(resultList);
            newResultList.add(me);
            dfs(numList, i, count - 1, target - me, newResultList);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

}
