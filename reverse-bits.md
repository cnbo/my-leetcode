## Reverse Bits

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as **00000010100101000001111010011100**), return 964176192 (represented in binary as **00111001011110000010100101000000**).

**Follow Up:**

If this function is called many times, how would you optimize it?

## 代碼實現

```
public class Solution {
    public static int reverseBits(int num) {
        StringBuilder bitsSb = intToBits(num);
        num = bitsToInt(bitsSb);

        return num;
    }

    public static int bitsToInt(StringBuilder bits) {
        double num = 0;

        int initExponent = 32 - bits.length();
        for (int i = 0; i < bits.length(); i++) {
            int digit = bits.charAt(i) - '0';
            num += Math.pow(2, i + initExponent) * digit;
        } 

        return (int) num;
    }

    public static StringBuilder intToBits(int num) {
        StringBuilder sb = null;

        int quotient = num / 2;
        int module = num % 2;
        if (quotient == 0) {
            return new StringBuilder().append(module);
        }

        sb = intToBits(quotient);
        sb.append(module);
        return sb;
    }
}
```
