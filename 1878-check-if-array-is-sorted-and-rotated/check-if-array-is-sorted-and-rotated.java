public class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Check if current element is greater than the next (with wrap-around)
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }
        
        // If there's 0 or 1 "drop", it's a sorted rotated array
        return count <= 1;
    }
}