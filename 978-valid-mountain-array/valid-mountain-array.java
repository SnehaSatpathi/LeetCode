class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length, i = 0;

        // 1. Climb up
        while (i + 1 < n && arr[i] < arr[i + 1]) i++;

        // 2. Peak can't be at the start or end
        if (i == 0 || i == n - 1) return false;

        // 3. Climb down
        while (i + 1 < n && arr[i] > arr[i + 1]) i++;

        // 4. Did we reach the end?
        return i == n - 1;
    }
}














