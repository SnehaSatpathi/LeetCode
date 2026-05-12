class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1; // Removed quotes and semicolon inside

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) { // Case-sensitive: 'target' instead of 'Target'
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Removed quotes and semicolon inside
    }
}
