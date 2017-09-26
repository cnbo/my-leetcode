## Nth Digit

Find the n<sup>th</sup> digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

**Note:**

n is positive and will fit within the range of a 32-bit signed integer (n < 2<sup>31</sup>).

**Example 1:**

> Input: 3  
> Output: 3

**Example 2:**

> Input: 11  
> Output: 0  
> Explanation:  
> The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of hte number 10.


## 代碼實現

```
public class Solution {
    public static int nthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int digit = 0;
        int count = 9;
        int digitBits = 2;

        while (n < Integer.MAX_VALUE) {
            int start = (int) Math.pow(10, digitBits - 1);
            int end = (int) Math.pow(10, digitBits);
            while (start < end) {
                int position = n - count;
                if (position <= digitBits) {
                    int loopCount = digitBits - position;
                    for (int i = 0; i <= loopCount; i++) {
                        digit = start % 10;
                        start /= 10;
                    }
                    return digit;
                }
                start++;
                count += digitBits;
           }
        }

        return digit;
    }
}
```
