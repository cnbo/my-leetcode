## count-and-say 問題描述

The count-and-say sequence is the sequence of integers with the first five terms as following:

> 1. 1
> 2. 11
> 3. 21
> 4. 1211
> 5. 111221
> 6. 312211

``1`` is read off as ``one 1`` or ``11``.  
``11`` is read off as ``two 1s`` or ``21``.   
``21`` is read off as ``one 2 one 1`` or ``1211``.
``1211`` is read off as ``one 1 one 2 two 1s`` or ``111221``.      
``111221`` is read off as ``three 1s two 2s one 1`` or ``312211``.

Given an integer n, generate the n<sup>th</sup> term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

**Example 1:**  
>  Input: 1  
> Output: "1"

**Example 2:**  
> Input: 5  
> Output: "111221"

## 代碼實現
```
public class Solucton {

    public static String getCountAndSay(int num) {
	StringBuilder say = new StringBuilder("1");
	for (int i = 1; i < num; i++) {
	    StringBuilder temp = new StringBuilder();
	    for (int j = 0; j < say.length(); j++) {
		int count = 1;
		char c = say.charAt(j);
		int k = j + 1;
		while (k < say.length()) {
		    if (c == say.charAt(k)) {
			count++;
			k++;
			continue;
		    }
		    k--;
		    break;
		}
		f (j != k) {
		    j = k;
		}

		temp.append(count).append(c);
	    }
	    say = temp;
	}
	return say.toString();
    }
}

```


