class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int target) {
        if (target <= 1) return 0; // Edge case where no product can be less than 1
        
        int n = nums.length;
        int count = 0;
        int pro = 1;
        int i = 0;

        // Sliding window
        for (int j = 0; j < n; j++) {
            pro *= nums[j];

            // Shrink the window if the product is greater than or equal to the target
            while (pro >= target && i <= j) {
                pro /= nums[i++];
            }

            // All subarrays ending at j and starting from any index between i and j have a product less than target
            count += j - i + 1;
        }

        return count;
    }
}
