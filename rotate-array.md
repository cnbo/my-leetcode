## Rotate Array

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array ``[1, 2, 3, 4, 5, 6, 7]`` is rotated to ``[5, 6, 7, 1, 2, 3, 4]``.

## 代碼實現

```
public class Solution {	
    public void rotate(int[] nums, int k) {
        if (isEmpty(nums)) {
            return;
        }
	
        k = k % nums.length;
        int endIndex = nums.length - 1;
        for (int i = 0; i < k; i++) {
            int temp = nums[endIndex];
            for (int j = endIndex; j > 0; j--) {
                nums[j] = nums[j - 1];
            } 
            nums[0] = temp;
        }
    }

    public boolean isEmpty(int[] nums) {
        return nums == null || nums.length == 0;
    }
}

```
