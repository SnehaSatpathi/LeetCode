class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Add a copy of the current subset to the result
        result.add(new ArrayList<>(currentSubset));

        for (int i = start; i < nums.length; i++) {
            // Include the current element
            currentSubset.add(nums[i]);
            
            // Move to the next element
            backtrack(result, currentSubset, nums, i + 1);
            
            // Backtrack: Remove the last element to explore other branches
            currentSubset.remove(currentSubset.size() - 1);
        }
     
    }
}