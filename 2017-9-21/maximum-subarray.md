## Maximum Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array ``[-2, 1, -3, 4, -1, 2, 1, -5, 4]``, the contiguous subarray ``[4, -1, 2, 1]`` has the largest sum = ``6``.

## 代碼實現

```
public class Solution {	
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int tempSum = 0;
            for (int j = i; j < nums.length; j++) {
                tempSum += nums[j];
                if (maxSum < tempSum) {
                    maxSum = tempSum;
                }
            }
        }

        return maxSum;
    }
}
```
