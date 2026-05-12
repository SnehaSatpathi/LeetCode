class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;         // Pointer for last valid element in nums1
        int j = n - 1;         // Pointer for last element in nums2
        int k = m + n - 1;     // Pointer for last available position in nums1

        // Loop while there are still elements to be merged from nums2
        while (j >= 0) {
            // If there are still elements in nums1 and its element is larger
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                // Otherwise, the element from nums2 is larger (or nums1 is empty)
                nums1[k--] = nums2[j--];
            }
        }
    }
}
