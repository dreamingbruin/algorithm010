package Week09;

public class ReverseString2 {

    public static class Solution {
        public String reverseStr(String s, int k) {
            if (k <= 1) {
                return s;
            }
            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; i += k) {
                if (i % (2 * k) == 0) {
                    int j = Math.min(array.length, i + k) - 1;
                    reverse(i, j, array);
                }
            }
            return new String(array);
        }

        private void reverse(int i, int j, char[] array) {
            char tmp;
            while (i < j) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcdefg", 3));
    }

}
