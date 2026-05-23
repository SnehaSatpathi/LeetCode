import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        // 1. Convert binary strings to BigInteger (radix 2 means binary)
        BigInteger numberA = new BigInteger(a, 2);
        BigInteger numberB = new BigInteger(b, 2);
        
        // 2. Add them together
        BigInteger sum = numberA.add(numberB);
        
        // 3. Convert the result back to a binary string (radix 2)
        return sum.toString(2);
    }
}
