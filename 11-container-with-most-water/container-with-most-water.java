class Solution {
    public int maxArea(int[] height) {
       int maxWater = 0;
       int left = 0;
       int right = height.length-1;

        while(left<right){
           int width = right - left;
            // Calculate current area based on smaller height
           int currentHeight = Math.min(height[left], height[right]);

           int currentArea = width * currentHeight;
           // Update maxWater if current area is larger
           maxWater = Math.max(maxWater, currentArea);
           // Move the pointer pointing to the shorter line
           if (height[left] < height[right]) {
                 left ++;
           } else{
            right--;
           }
        }
    // Return must be outside the while loop
    return maxWater;
    }
}





 