class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        result[0] = findPosition(nums, target, true);  // Find first
        result[1] = findPosition(nums, target, false); // Find last
        return result;
    }

    private int findPosition(int[] nums, int target, boolean isFirst) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                index = mid; // Found it! But keep looking...
                if (isFirst) {
                    high = mid - 1; // Look left for earlier one
                } else {
                    low = mid + 1;  // Look right for later one
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
}
 
