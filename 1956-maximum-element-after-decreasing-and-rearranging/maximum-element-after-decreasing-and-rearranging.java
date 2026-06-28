class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // Sort the array to process elements in increasing order
        Arrays.sort(arr);
        
        // The first element must always be 1
        arr[0] = 1;
        
        //each element is at most 1 greater than the previous
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        
        // The largest value will be at the end of the sorted, modified array
        return arr[arr.length - 1];
    }
}