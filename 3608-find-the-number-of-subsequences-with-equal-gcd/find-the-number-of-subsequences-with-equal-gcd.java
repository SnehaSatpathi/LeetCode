public class Solution {
    private static final int MOD = 1000000007;
    private static final int MAX_V = 200;

    public int subsequencePairCount(int[] nums) {

        int[][] dp = new int[MAX_V + 1][MAX_V + 1];
        dp[0][0] = 1; 

        for (int x : nums) {
            int[][] nextDp = new int[MAX_V + 1][MAX_V + 1];
            

            for (int j = 0; j <= MAX_V; j++) {
                System.arraycopy(dp[j], 0, nextDp[j], 0, MAX_V + 1);
            }


            for (int j = 0; j <= MAX_V; j++) {
                for (int k = 0; k <= MAX_V; k++) {
                    if (dp[j][k] == 0) continue;

                 
                    int nj = gcd(j, x);
                    nextDp[nj][k] = (nextDp[nj][k] + dp[j][k]) % MOD;


                    int nk = gcd(k, x);
                    nextDp[j][nk] = (nextDp[j][nk] + dp[j][k]) % MOD;
                }
            }
            dp = nextDp;
        }


        long totalPairs = 0;
        for (int g = 1; g <= MAX_V; g++) {
            totalPairs = (totalPairs + dp[g][g]) % MOD;
        }

        return (int) totalPairs;
            }


    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}


        
    
