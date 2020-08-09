package Week09;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public static class Solution {
        public int firstUniqChar(String s) {
            char[] chars = s.toCharArray();
            if (chars.length == 0) {
                return -1;
            }
            if (chars.length == 1) {
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (char c : chars) {
                map.compute(c, (c1, v) -> v == null? 1 : v + 1);
            }
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (map.get(c) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

}
