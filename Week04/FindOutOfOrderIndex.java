package Week04;

import Common.Pair;
import Common.Tests;

public class FindOutOfOrderIndex {

    public static class Solution {

        public int find(int[] array) {
            return incursion(array, 0, array.length - 1);
        }

        private int incursion(int[] array, int left, int right) {
            if (left > right) {
                return -1;
            }
            int index = (left + right) / 2;
            if (index == 0) {
                return -1;
            }
            if (array[index] < array[index - 1] && (index == array.length - 1 || array[index] < array[index + 1])) {
                return index;
            }
            if (array[index] > array[0]) {
                return incursion(array, index + 1, right);
            }
            return incursion(array, left, index - 1);
        }

    }

    public static void main(String[] args) {
        Tests.execute(Solution.class,
                new Pair<>(new Object[]{new int[]{4, 5, 6, 7, 0, 1, 2}}, 4),
                new Pair<>(new Object[]{new int[]{4, 5, 6, 7, 0}}, 4),
                new Pair<>(new Object[]{new int[]{4, 5, 6, 7}}, -1),
                new Pair<>(new Object[]{new int[]{4}}, -1),
                new Pair<>(new Object[]{new int[]{}}, -1)
        );
    }

}
