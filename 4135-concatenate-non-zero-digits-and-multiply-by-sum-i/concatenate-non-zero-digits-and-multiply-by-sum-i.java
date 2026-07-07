class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0) {
            return 0;
        }

        long x = 0;
        long sum = 0;
        long placeValue = 1;
        int temp = n;

        // Process digits from right to left
        while (temp > 0) {
            int digit = temp % 10;
            
            
            if (digit != 0) {
                x = (digit * placeValue) + x; 
                placeValue *= 10;             
                sum += digit;
            }
            
            temp /= 10;
        }

        // Return the product of x and the sum of its digits
        return x * sum;
    
    }
}