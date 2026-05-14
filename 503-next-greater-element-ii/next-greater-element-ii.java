class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int i;
        int j;
        int[] result = new int[n];
        // Initialize all elements with -1 by default
        Arrays.fill(result, -1);
        for(i = 0; i < n; i++){
            for(j = 1; j < n; j++){
                int nextindex = (i+j) % n;
                if(nums[nextindex] > nums[i]){
                    result [i] = nums[nextindex];
                    break;
                }
            }
        }
        return result;
    }
}