class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] count = new int[50000], first = new int[50000];
        // Initialize first-seen array with -1 to track new numbers
        java.util.Arrays.fill(first, -1);
        
        int degree = 0, minLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (first[n] == -1) first[n] = i; // Record first index
            
            count[n]++; // Increase frequency
            
            if (count[n] > degree) {
                degree = count[n];
                minLength = i - first[n] + 1;
            } else if (count[n] == degree) {
                minLength = Math.min(minLength, i - first[n] + 1);
            }
        }
        return minLength;
    }
}
