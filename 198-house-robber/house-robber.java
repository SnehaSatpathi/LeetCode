class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] House_Profit = new int[nums.length];

        House_Profit[0] = nums[0];
        House_Profit[1] = Math.max(nums[0], nums[1]);

        House_Profit[2] = Math.max(House_Profit[2-1], nums[2] + House_Profit[2-2]);

        for(int i = 3; i < nums.length; i++) {
            House_Profit[i] = Math.max(House_Profit[i-1],
                                       nums[i] + House_Profit[i-2]);
        }

        return House_Profit[nums.length-1];
    }
}
