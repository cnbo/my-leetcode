## Implement strStr()

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

## 代碼實現

```
public class Solution {
    public int strStr(String haystack, String needle) {
        int result = -1;
        if (isEmpty(haystack) || isEmpty(needle) || (haystack.length() < needle.length())) {
            return result;
        }   

        int haystackLength = haystack.length();
        for (int i = 0; i < haystackLength; i++) {
            String temp = haystack.substring(i, haystackLength);
            if (temp.length() < needle.length()) {
                break;
            } 
            if (temp.startsWith(needle)) {
                result = i;
                break;
            }
        }
	
        return result;
    }

    public boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
```
