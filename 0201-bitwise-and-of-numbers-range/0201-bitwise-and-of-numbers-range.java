class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        // Keep shifting right until left and right are equal
        while (left < right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        // Shift left by count to get the common bits
        return left << count;
    }
}