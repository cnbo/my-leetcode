## Ugly Number

Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include ``2, 3, 5``. For example, ``6, 8`` are ugly while ``14`` is not ugly since it includes another prime factor ``7``.

Note that ``1`` is typically treated as an ugly number.

## 代碼實現

```
public class Solution {
    public static boolean uglyNumber(int num) {
        if (num == 0) {
            return false;
        }
        
        if (num == 1 || num == 2 || num == 3 || num == 5) {
            return true;
        }

        if (num % 2 == 0) {
            return uglyNumber(num / 2);
        }
        if (num % 3 == 0) {
            return uglyNumber(num / 3);
        }
        if (num % 5 == 0) {
            return uglyNumber(num / 5);
        }

        return false;
    }
}
```
