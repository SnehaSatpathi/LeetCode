class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1_000_000_007;
        int m = r - l + 1;
        int T = 2 * m;

        // Base matrix
        long[][] trans = new long[T][T];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i < j) {
                    // Current step went UP next step MUST go DOWN
                    trans[j][i + m] = 1; 
                } else if (i > j) {
                    // Current step went DOWN next step MUST go UP
                    trans[j + m][i] = 1; 
                }
            }
        }

        // Raise transition matrix to the power of (n - 2) for elements 3 to n
        long[][] res = matrixPower(trans, n - 2, MOD);

        // Calculate total valid arrays
        long total = 0;
        
        // Base case vector for length n = 2:
        // count[i] is the number of valid pairs ending at element i with type UP
        // count[i+m] is the number of valid pairs ending at element i with type DOWN
        long[] baseCount = new long[T];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i < j) baseCount[j] = (baseCount[j] + 1) % MOD;
                if (i > j) baseCount[j + m] = (baseCount[j + m] + 1) % MOD;
            }
        }

        // Multiply the base vector by the exponentiated transition matrix
        for (int j = 0; j < T; j++) {
            long currentCount = 0;
            for (int i = 0; i < T; i++) {
                currentCount = (currentCount + baseCount[i] * res[i][j]) % MOD;
            }
            total = (total + currentCount) % MOD;
        }

        return (int) total;
    }

    private long[][] matrixPower(long[][] A, int p, int MOD) {
        int n = A.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1;
        
        long[][] base = A;
        while (p > 0) {
            if ((p & 1) == 1) {
                res = multiply(res, base, MOD);
            }
            base = multiply(base, base, MOD);
            p >>= 1;
        }
        return res;
    }

    private long[][] multiply(long[][] A, long[][] B, int MOD) {
        int n = A.length;
        long[][] C = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }
}


        
    
