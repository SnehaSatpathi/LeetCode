class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize with the first element
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        // Loop through the rest of the array starting at index 1
        for (int i = 1; i < nums.length; i++) {
            // extend the previous subarray or start fresh at nums[i]?
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            
            // Keep track of the best sum 
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}
