class Solution {
    private static final int MOD = 1_000_000_007;

    // Custom class to track values inside each segment
    private static class Node {
        long val;   // Value x formed after skipping zeros 
        long sum;   // True sum of non-zero digit
        int count;  // Count of non-zero digits in this range

        Node(long val, long sum, int count) {
            this.val = val;
            this.sum = sum;
            this.count = count;
        }
    }

    private Node[] tree;
    private long[] power10;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        int n = queries.length;

        //  Precompute powers of 10 modulo 10^9 + 7
        power10 = new long[m + 1];
        power10[0] = 1;
        for (int i = 1; i <= m; i++) {
            power10[i] = (power10[i - 1] * 10) % MOD;
        }

        //  Build the segment tree
        tree = new Node[4 * m];
        buildTree(s, 0, 0, m - 1);

        //  Process each query
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];

            Node res = queryTree(0, 0, m - 1, li, ri);
            
            // Calculate (x * sum) % MOD
            long totalSumMod = res.sum % MOD;
            long ans = (res.val * totalSumMod) % MOD;
            answer[i] = (int) ans;
        }

        return answer;
    }

    private void buildTree(String s, int node, int start, int end) {
        if (start == end) {
            int digit = s.charAt(start) - '0';
            if (digit != 0) {
                tree[node] = new Node(digit, digit, 1);
            } else {
                tree[node] = new Node(0, 0, 0);
            }
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        buildTree(s, leftChild, start, mid);
        buildTree(s, rightChild, mid + 1, end);

        tree[node] = merge(tree[leftChild], tree[rightChild]);
    }

    private Node queryTree(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return new Node(0, 0, 0); // Out of bounds neutral element
        }
        if (l <= start && end <= r) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;
        Node leftRes = queryTree(2 * node + 1, start, mid, l, r);
        Node rightRes = queryTree(2 * node + 2, mid + 1, end, l, r);

        return merge(leftRes, rightRes);
    }

    private Node merge(Node left, Node right) {
        int count = left.count + right.count;
        long sum = left.sum + right.sum;
        
        // Combine values: left value shifted left by the number of digits on the right
        long val = (left.val * power10[right.count]) % MOD;
        val = (val + right.val) % MOD;

        return new Node(val, sum, count);
    }
}


        
    
