## Single Number

Given an array of integers, every element appears twice except for one. Find that single one.

**Note:**  
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

## 代碼實現

```
public class Solution {	
    public static int getSingleOne(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] < nums[i + 1]) {
                return nums[i];
            }
        }

        return 0;
    }
}

```
