public class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1_000_000_007, range = r - l + 1;
        long[][] dp = new long[range][2];
        
        // Base case for length 1
        for (int j = 0; j < range; j++) {
            dp[j][0] = dp[j][1] = 1;
        }

        // DP transitions for length 2 up to n
        for (int i = 2; i <= n; i++) {
            long[][] next = new long[range][2];
            long sumUp = 0, sumDown = 0;

            for (int j = 0; j < range; j++) {
                // Moving right: accumulate valid steps from the left
                next[j][0] = sumUp; // To go UP to j, previous must have gone DOWN
                sumUp = (sumUp + dp[j][1]) % MOD;

                // Moving left from the right side
                int revj = range - 1 - j;
                next[revj][1] = sumDown; // To go DOWN to revj, previous must have gone UP
                sumDown = (sumDown + dp[revj][0]) % MOD;
            }
            dp = next;
        }

        long ans = 0;
        for (int j = 0; j < range; j++) {
            ans = (ans + (n == 1 ? dp[j][0] : dp[j][0] + dp[j][1])) % MOD;
        }
        return (int) ans;
    }
}


        
    
