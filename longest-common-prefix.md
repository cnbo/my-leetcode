## Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

## 代碼實現

```
public class Solucton {
    public String longestCommonPrefix(String[] strs) {
	String commonLongestPrefix = "";
	int shortStrIndex = getShortStrIndex(strs);
	String longestPrefix = strs[shortStrIndex];
	for (int i = longestPrefix.length(); i > 0; i--) {
	    boolean isCommonPrefix = true;
	    String temp = longestPrefix.substring(0, i);
	    for (int j = 0; j < strs.length; j++) {
		if (strs[j].startsWith(temp)) {
		    continue;
		}
		sCommonPrefix = false;
		break;
	    }
	    if (isCommonPrefix) {
		commonLongestPrefix = temp;
		break;
	    }
	}
	return commonLongestPrefix;
    }

    public int getShortStrIndex(String[] strs) {
	int shortStrIndex = 0;
	int strLength = strs[0].length();
		
	for (int i = 1; i < strs.length; i++) {
	    if (strLength > strs[0].length()) {
		shortStrIndex = i;
		trLength = strs[0].length();
	    }
	}
	return shortStrIndex;
    }
}
```
