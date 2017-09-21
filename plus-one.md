## Plus One

Given a non-negative integer represented as a **non-empty** array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

## 中文意思

给出一个由整型数组表示的非负数字，将这个数字加一。数组中的各元素表示该数字的各位，越靠前的元素权越大。

## 代碼實現

```
public class Solution {	
    public static void plusOne(int[] nums) {
        addOne(nums, nums.length - 1);
    }

    public static void addOne(int[] nums, int index) {
        if (index == 0 || nums[index] < 9) {
            nums[index]++;
            return;
        } else if (nums[index] == 9) {
            nums[index] = 0;
            addOne(nums, index - 1);
        }
    }
}

```
