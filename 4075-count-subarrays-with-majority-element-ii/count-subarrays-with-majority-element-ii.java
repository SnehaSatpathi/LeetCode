class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        

        int shift = n + 1;
        int bitSize = 2 * n + 2;
        int[] bit = new int[bitSize];
        
        long totalSubarrays = 0;
        int currentPrefixSum = 0;
        


        int initIdx = currentPrefixSum + shift;
        while (initIdx < bitSize) {
            bit[initIdx] += 1;
            initIdx += initIdx & (-initIdx);
        }
        

        for (int num : nums) {

            currentPrefixSum += (num == target) ? 1 : -1;
            

            int queryIdx = (currentPrefixSum + shift) - 1;
            long smallerCounts = 0;
            while (queryIdx > 0) {
                smallerCounts += bit[queryIdx];
                queryIdx -= queryIdx & (-queryIdx);
            }
            
            totalSubarrays += smallerCounts;
            

            int updateIdx = currentPrefixSum + shift;
            while (updateIdx < bitSize) {
                bit[updateIdx] += 1;
                updateIdx += updateIdx & (-updateIdx);
            }
        }
        
        return totalSubarrays;
    }
}


        
    
