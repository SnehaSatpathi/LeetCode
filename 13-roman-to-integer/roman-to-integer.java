class Solution {
    public int romanToInt(String s) {

        int total = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int current = getValue(s.charAt(i));
            
            // If there is a next character and it's bigger than the current one
            if (i + 1 < s.length() && current < getValue(s.charAt(i + 1))) {
                total -= current; // Subtract it
            } else {
                total += current; // Otherwise, add it
            }
        }
        
        return total;
    }

    // Helper method to turn letters into numbers
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
