## Implement strStr()

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

## 代碼實現

```
public class Solution {
    public int strStr(String haystack, String needle) {
        int result = -1;
        if (haystack == null || needle == null || (haystack.length() < needle.length())) {
            return result;
        }   
        
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
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
}
```
