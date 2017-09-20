## Remove Element

Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

**Example:**
> Given input array nums = ``[3, 2, 2, 3]``, val = ``3``   
> Your function should return length = 2, with first two elements of nums being 2.


## 代碼實現

```
public int removeElement(int[] nums, int val) {
    int count  = 0;
    int valStartIndex = 0;
    Arrays.sort(nums);

    A:for (int i = 0; i < nums.length; i++) {
        if (val != nums[i]) {
	    continue;
	}
	valStartIndex = i;
	while (i < nums.length) {
	    if (val == nums[i]) {
	        count++;
	        i++;
	        continue;
	     }
	     break A;
	}
     }

     for (int i = valStartIndex + count; i < nums.length; i++) {
	nums[i - count] = nums[i];
     }

     if (count == 1 && nums.length == 1) {
	return 0;
     } else {
	return nums.length - count;
     }
}
```
