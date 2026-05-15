class Solution {
    public int rob(int[] nums) {
        // only one house
        if (nums.length == 1) return nums[0];
        // First Case - Rob from first house to second-to-last
        int robFirst = linearRob(nums, 0, nums.length - 2);
        // Second Case - Rob from second house to the last
        int robLast = linearRob(nums, 1, nums.length - 1);
        return Math.max(robFirst, robLast);
    }
    private int linearRob(int[] nums, int start, int end) {
        int prevMax = 0; // Max money 2 houses ago
        int currMax = 0; // Max money 1 house ago
        for (int i = start; i <= end; i++) {
            // Decide to either rob this house or skip it
            int temp = Math.max(currMax, prevMax + nums[i]);
            prevMax = currMax;
            currMax = temp;
        }
        return currMax;
    }
}
