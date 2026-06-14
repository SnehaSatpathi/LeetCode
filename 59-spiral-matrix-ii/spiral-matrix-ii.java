public class Solution {
    public int[][] generateMatrix(int n) {
        // Initialize an n x n matrix
        int[][] matrix = new int[n][n];
        
        // Define boundaries
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        
        // Value to fill in the matrix
        int num = 1;
        
        // Loop until all layers are filled
        while (left <= right && top <= bottom) {
            
            // 1. Traverse right across the top row
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++; // Shrink top boundary
            
            // 2. Traverse down the rightmost column
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--; // Shrink right boundary
            
            // 3. Traverse left across the bottom row
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--; // Shrink bottom boundary
            
            // 4. Traverse up the leftmost column
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++; // Shrink left boundary
        }
        
        return matrix;
    }
}


        
    
