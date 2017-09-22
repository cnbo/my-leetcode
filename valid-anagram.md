## Valid Anagram

Given two strings s and t, write a function to determine if i is an anagram of s.

For example, a = "anagram", t = "nagaram", return true. s = "rat", t = "car", return false.

**Note:** 

You may assume the string contains only lowercase alphabets.

**Follow up:**

What if the inputs contain unicode characters? How would you adapt your solution to such case?

## 代碼實現

```
public class Solution {
    public static boolean validAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        } 

        char[] sChars = s.toCharArray(), tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }

        return true;
    }
}
```
