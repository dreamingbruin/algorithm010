package Week07;

import java.util.*;

public class FriendCircles {

    private static class Solution1 {
        public int findCircleNum(int[][] M) {
            List<Set<Integer>> sets = new ArrayList<>();
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M.length; j++) {
                    if (M[i][j] != 1) {
                        continue;
                    }
                    if (i == j) {
                        continue;
                    }
                    Set<Integer> set;
                    if (!map.containsKey(i) && !map.containsKey(j)) {
                        set = new HashSet<>();
                        set.add(i);
                        set.add(j);
                        sets.add(set);
                        map.put(i, set);
                        map.put(j, set);
                        continue;
                    }
                    Set<Integer> setI = map.get(i);
                    Set<Integer> setJ = map.get(j);
                    if (setI == null) {
                        setJ.add(i);
                        map.put(i, setJ);
                        continue;
                    }
                    if (setJ == null) {
                        setI.add(j);
                        map.put(j, setI);
                        continue;
                    }
                    if (setI == setJ) {
                        continue;
                    }
                    setI.addAll(setJ);
                    for (Integer member : setJ) {
                        map.put(member, setI);
                    }
                    sets.remove(setJ);
                }
            }
            HashSet<Integer> all = new HashSet<>(M.length);
            for (int i = 0; i < M.length; i++) {
                all.add(i);
            }
            // find all lone members
            for (Set<Integer> set : sets) {
                for (Integer member : set) {
                    all.remove(member);
                }
            }
            // return: circle number + lone members' number
            return sets.size() + all.size();
        }

        public static void main(String[] args) {
            int[][] m = new int[][]{
                    {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
            };
            System.out.println(new Solution1().findCircleNum(m));
        }
    }

}
