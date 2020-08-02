package Week08;

public class NumberOfOneBits {
    public static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                n = n & (n - 1);
                count += 1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(11));
    }
}
