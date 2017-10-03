## Valid Perfect Square

Given a positive integer num, write a function which returns True if num is a perfect square else False.

**Note: Do not** use any built-in library function such as ``sqrt``.

**Example 1:**

> Input: 16
> Returns: True

**Example 2:**

> Input: 14
> Returns: False

## 代碼實現

```
public class Solution {	
    public static boolean perfectSquare(int num) {
        boolean result = false;

        int cycleCount = num / 2;
        for (int i = 1; i <= cycleCount; i++) {
            if (i * i == num) {
                result = true;
            }
        }

        return num == 1 ? true : result;
    }
}
```
