## Two Sum

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would hava **exactly** one solution, and you may not use the same element twice.

**Example:**
> Given nums = [2, 7, 11, 5], target = 9,  
> Because nums[0] + nums[1] = 2 + 7 = 9,  
> return [0, 1].

## 代碼實現

```
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }

        return indices;
    }
}
```
