## Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears **more than** ``n/2`` times.

You may assume that the array is non-empty and the majority element always exist in the array.

## 代碼實現

```
public class Solution {	
    public int majorityElement(int[] nums) {
        int leastCount = nums.length / 2;
        int result = 0;
        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            Integer count = numsMap.get(nums[i]);
            if (count == null) {
                numsMap.put(nums[i], 1);
                continue;
            } 
            if (count <= leastCount) {
                count++;
                numsMap.put(nums[i], count);
            } 
            if (count > leastCount) {
                result = nums[i];
            }
        }

        return result;
    }
}
```
