学习总结

* 题目：使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
* 思路：与二分查找的不同点是查找成功的判定条件不同，其他基本一致
* 代码：
```java
public static class Solution {

    public int find(int[] array) {
        return recursion(array, 0, array.length - 1);
    }

    private int recursion(int[] array, int left, int right) {
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
            return recursion(array, index + 1, right);
        }
        return recursion(array, left, index - 1);
    }

}
```
* 测试用例
	* [4, 5, 6, 7, 0, 1, 2] -> 4
	* [4, 5, 6, 7, 0] -> 4
	* [4, 5, 6, 7] -> -1
	* [4] -> -1
	* [] -> -1