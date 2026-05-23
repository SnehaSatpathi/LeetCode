class Solution {
    public int[] findArray(int[] pref) {
        // Iterate backwards to update in-place
        for (int i = pref.length - 1; i > 0; i--) {
            pref[i] = pref[i] ^ pref[i - 1];
        }
        return pref;
    }
}
