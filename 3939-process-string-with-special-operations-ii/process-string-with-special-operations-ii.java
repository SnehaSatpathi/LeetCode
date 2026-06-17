public class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] lengths = new long[n];
        long currentLength = 0;

        // Step 1: Track the exact string length after each operation
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                if (currentLength > 0) {
                    currentLength--;
                }
            } else if (ch == '#') {
                currentLength *= 2;
            } else if (ch == '%') {
                // Reversal does not alter the current length
            } else {
                currentLength++;
            }
            lengths[i] = currentLength;
        }

        // Out of bounds validation
        if (k < 0 || k >= currentLength) {
            return '.';
        }

        // Step 2: Traverse backward to map the index k to its original character
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long prevLen = (i == 0) ? 0 : lengths[i - 1];

            if (ch == '*') {
                // Character was dropped; the active range for k stays the same
                continue;
            } else if (ch == '#') {
                // String duplicated: if k lands in the second half, shift it to the first half
                if (k >= prevLen) {
                    k -= prevLen;
                }
            } else if (ch == '%') {
                // String reversed: index k maps to (prevLen - 1 - k) from the opposite side
                k = prevLen - 1 - k;
            } else {
                // Standard lowercase English letter was appended at index 'prevLen'
                if (k == prevLen) {
                    return ch;
                }
                // If k < prevLen, its index position remains unaffected
            }
        }

        return '.';
    }
}


        
    
