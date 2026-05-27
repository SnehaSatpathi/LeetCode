import java.util.*;

class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] memo = new int[n]; 
        int maxVisited = 0;

        for (int i = 0; i < n; i++) {
            maxVisited = Math.max(maxVisited, dfs(arr, d, i, memo));
        }

        return maxVisited;
    }

    private int dfs(int[] arr, int d, int i, int[] memo) {
        if (memo[i] != 0)
         return memo[i];

        int res = 1;
        int n = arr.length;

        // Check right
        for (int j = i + 1; j <= i + d && j < n; j++) {
            if (arr[j] >= arr[i])
             break;
            res = Math.max(res, 1 + dfs(arr, d, j, memo));
        }

        // Check left
        for (int j = i - 1; j >= i - d && j >= 0; j--) {
            if (arr[j] >= arr[i])
             break;
            res = Math.max(res, 1 + dfs(arr, d, j, memo));
        }

        return memo[i] = res;
    }
}