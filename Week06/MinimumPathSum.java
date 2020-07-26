package Week06;

import java.util.HashMap;
import java.util.Map;

public class MinimumPathSum {

    private static class Solution1 {

        public int minPathSum(int[][] grid) {
            return dp(grid);
        }

        private int dp(int[][] grid) {
            int r = grid.length;
            int c = grid[0].length;
            Map<String, Integer> map = new HashMap<>(grid.length * grid[0].length);
            for (int i = r - 1; i >= 0; i--) {
                for (int j = c - 1; j >= 0; j--) {
                    String key = getKey(i, j);
                    int value = grid[i][j];
                    int sum;
                    if (i == r - 1 && j == c - 1) {
                        sum = value;
                    } else if (i == r - 1) {
                        sum = value + map.get(getKey(i, j + 1));
                    } else if (j == c - 1) {
                        sum = value + map.get(getKey(i + 1, j));
                    } else {
                        sum = value + Math.min(
                                map.get(getKey(i, j + 1)),
                                map.get(getKey(i + 1, j))
                        );
                    }
                    map.put(key, sum);
                }
            }
            return map.get(getKey(0, 0));
        }

        private String getKey(int i, int j) {
            return i + "-" + j;
        }

    }

    private static class Solution2 {

        public int minPathSum(int[][] grid) {
            return dp(grid);
        }

        private int dp(int[][] grid) {
            int r = grid.length;
            int c = grid[0].length;
            for (int i = r - 1; i >= 0; i--) {
                for (int j = c - 1; j >= 0; j--) {
                    int value = grid[i][j];
                    int sum;
                    if (i == r - 1 && j == c - 1) {
                        sum = value;
                    } else if (i == r - 1) {
                        sum = value + grid[i][j + 1];
                    } else if (j == c - 1) {
                        sum = value + grid[i + 1][j];
                    } else {
                        sum = value + Math.min(
                                grid[i][j + 1],
                                grid[i + 1][j]
                        );
                    }
                    grid[i][j] = sum;
                }
            }
            return grid[0][0];
        }

    }

}
