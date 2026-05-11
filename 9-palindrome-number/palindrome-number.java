class Solution {
    public boolean isPalindrome(int x) {
   // Step 1: Negative numbers and numbers ending in 0 or except 0 itself  are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int original = x;
        int reversed = 0;
    // Step 2: Reverse the number mathematically
        while (x > 0) {
            int lastDigit = x % 10; // Get the last digit
            reversed = (reversed * 10) + lastDigit; // Shift left and add digit
            x = x / 10;    // Remove the last digit
        }

    // Step 3: Compare original with reversed
        return original == reversed;
    }
} 
