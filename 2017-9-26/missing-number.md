## Missing Number

Given an array containing n distinct numbers taken from ``0, 1, 2, ..., n``, find the one that is missing from the array.

For example, Given nums = ``[0, 1, 3]`` return ``2``.

**Note:**

Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

## 代碼實現

```
public class Solution {
    public static int missingNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i <= nums.length; i++) {
            boolean isMissing = true;
            for (int j = 0; j < nums.length; j++) {
                if (i == nums[j]) {
                    isMissing = false;
                    break;
                }
            }
            if (isMissing) {
                return i;
            }
       }

       return result;
    }
}
```
