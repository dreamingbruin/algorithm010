package Week02;

import Common.Pair;
import Common.Tests;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ValidAnagrams {

    public static class Solution1 {
        public boolean isAnagram(String s, String t) {
            if (s == null || t == null) {
                return false;
            }
            if (s.length() != t.length()) {
                return false;
            }
            Map<Character, Integer> map = new HashMap<>(16);
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            for (char c : t.toCharArray()) {
                if (map.containsKey(c)) {
                    Integer count = map.get(c);
                    if (count == 0) {
                        return false;
                    }
                    map.put(c, count - 1);
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    public static class Solution2 {
        public boolean isAnagram(String s, String t) {
            if (s == null || t == null) {
                return false;
            }
            if (s.length() != t.length()) {
                return false;
            }
            int[] array = new int[26];
            for (char c : s.toCharArray()) {
                array[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                array[c - 'a']--;
                if (array[c - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Pair<?, ?>[] cases = {
                new Pair<>(new Object[]{"rat", "c"}, false),
                new Pair<>(new Object[]{"anagram", "nagaram"}, true),
                new Pair<>(new Object[]{"rat", "car"}, false)};
        Stream.of(Solution1.class, Solution2.class).forEach((clazz) -> Tests.execute(clazz, cases));
    }

}
