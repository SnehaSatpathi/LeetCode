class Solution {
    public int lengthOfLastWord(String s) {
        // Trim any trailing spaces from the string
        s = s.trim();
        
        // Find the index of the last space
        int lastSpace = s.lastIndexOf(' ');
        
        // If there's no space, the whole string is the last word
        if (lastSpace == -1) {
            return s.length();
        }
        
        // Otherwise, return the length of the substring after the last space
        return s.length() - 1 - lastSpace;
    }
}
