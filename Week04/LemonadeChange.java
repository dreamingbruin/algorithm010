package Week04;

import Common.Pair;
import Common.Tests;

public class LemonadeChange {

    public static class Solution {
        public boolean lemonadeChange(int[] bills) {
            if (bills.length < 2 || bills[0] != 5) {
                return false;
            }
            int five = 0, ten = 0;
            for (int bill : bills) {
                switch (bill) {
                    case 5:
                        five += 1;
                        break;
                    case 10:
                        if (five <= 0) {
                            return false;
                        }
                        five -= 1;
                        ten += 1;
                        break;
                    case 20:
                        if (five > 0 && ten > 0) {
                            five -= 1;
                            ten -= 1;
                        } else if (five > 2) {
                            five -= 3;
                        } else {
                            return false;
                        }
                        break;
                    default:
                        throw new IllegalArgumentException(String.format("Unknown bill: [%d]", bill));
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Pair<?, ?>[] pairs = {
                new Pair<>(new Object[]{new int[]{5, 5, 5, 10, 20}}, true),
                new Pair<>(new Object[]{new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5}}, true)
        };
        Tests.execute(Solution.class, pairs);
    }

}
