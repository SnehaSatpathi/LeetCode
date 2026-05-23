class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        // Result can be at most 1 character longer than the longest input
        char[] result = new char[Math.max(i, j) + 2];
        int k = result.length - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            
            result[k--] = (char) ((sum % 2) + '0');
            carry = sum / 2;
        }

        // k points to the index before the first digit. 
        // If there was a final carry, k will be result.length - (sum_length + 1).
        return new String(result, k + 1, result.length - k - 1);
    }
}

