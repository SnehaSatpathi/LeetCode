import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case check
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        // Initialize boundaries
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        // Traverse until boundaries overlap
        while (left <= right && top <= bottom) {
            
            // 1. Move right across the top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Row finished, shrink top boundary
            
            // 2. Move down along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Column finished, shrink right boundary
            
            // 3. Move left across the bottom row (if rows remain)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Row finished, shrink bottom boundary
            }
            
            // 4. Move up along the left column (if columns remain)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Column finished, shrink left boundary
            }
        }
        
        return result;
    }
}


        
    
