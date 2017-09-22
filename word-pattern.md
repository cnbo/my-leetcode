## Word Pattern

Given a ``pattern`` and a string ``str``, find if ``str`` follows the same pattern.

Here **follow** means a full match, such that there is a bijection between a letter in ``pattern`` and a **noe-empty** word in ``str``.

**Example:**

- pattern = ``"abba"``, str = ``"dog cat cat dog"`` should return true.
- pattern = ``"abba"``, str = ``"dog cat cat fish"`` should return false.
- pattern = ``"aaaa"``, str = ``"dog cat cat dog"`` should return false.
- pattern = ``"abba"``, str = ``"dog dog dog dog"`` should return false.

**Note:**
You may assume ``pattern`` contains only lowercase letters, and ``str`` contains lowercase letters separated by a single space.

## 代碼實現

```
public class Solution {	
    public static boolean wordPattern(String str, String pattern) {
        if (str == null && pattern == null) {
            return true;
        } else if (str == null) {
            return false;
        } else if (pattern == null) {
            return false;
        } else if (str.equals(pattern)) {
            return true;
        }

        boolean isPattern = true;
		
        String[] strs = str.split(" ");
        A:for (int i = 0; i < pattern.length(); i++) {
            char patternChar = pattern.charAt(i);
            String strTemp = strs[i];
            for (int j = i; j < pattern.length(); j++) {
            if (patternChar == pattern.charAt(j) && strTemp.equals(strs[j])) {
                continue;
            } else if (patternChar != pattern.charAt(j) && !strTemp.equals(strs[j])) {
                continue;
            }
            isPattern = false;
            break A;
        }

        return isPattern;
    }
}
```
