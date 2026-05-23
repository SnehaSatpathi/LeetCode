class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }

        diff &= -diff;

        int[] res = {0, 0};
        for (int n : nums) {
            if ((n & diff) == 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }
        return res;
    }
}
