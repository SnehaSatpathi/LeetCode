class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Look at every number in the array
        for (int i = 0; i < nums.length; i++) {
            
            // Look at every number after the first one
            for (int j = i + 1; j < nums.length; j++) {
                
                // If they add up to the target, we found it!
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        // If no pair is found (though the problem says there is one)
        return new int[] {};
    }
}
