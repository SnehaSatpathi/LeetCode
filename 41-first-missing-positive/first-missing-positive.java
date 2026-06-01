class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each number in its correct position if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with the element at its target index
                int targetIndex = nums[i] - 1;
                int temp = nums[targetIndex];
                nums[targetIndex] = nums[i];
                nums[i] = temp;
            }
        }

        // Find the first index where the number is not correct
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all numbers 1 to n are present, the answer is n + 1
        return n + 1;
    }
}
