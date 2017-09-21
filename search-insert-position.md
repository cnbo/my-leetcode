## Search Insert Position

Given a sorted array and a target value, return the index if the target is found. if not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
> ``[1, 3, 5, 6]``, 5 -> 2  
> ``[1, 3, 5, 6]``, 2 -> 1  
> ``[1, 3, 5, 6]``, 7 -> 4  
> ``[1, 3, 5, 6]``, 0 -> 0

## 代碼實現

```
public class Solucton {	
    public int getInsertPosition(int[] nums, int val) {
        if (isEmpty(nums)) {
            return 0;
        }
        int result = 0;

        if (val > nums[nums.length - 1]) {
            return nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            if (val <= nums[i]) {
                result = i;
                break;
            }
       }

       return result;
    }

    public boolean isEmpty(int[] nums) {
        return nums == null || nums.length == 0;
    }
}

```
