class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int totalLength = n + m;
        int target = (totalLength + 1) / 2; 

        // Ensure nums1 is smaller or equal in size
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = n;

        while (left <= right) {
            int partitionA = left + (right - left) / 2;
            int partitionB = target - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int minRightA = (partitionA == n) ? Integer.MAX_VALUE : nums1[partitionA];

            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightB = (partitionB == m) ? Integer.MAX_VALUE : nums2[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                // Perfect partition found
                if (totalLength % 2 == 0) {
                    // Even length merged array
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    // Odd length merged array
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                // Move left in nums1
                right = partitionA - 1;
            } else {
                // Move right in nums1
                left = partitionA + 1;
            }
        }

        // Invalid input (arrays not sorted)
        return 0.0;
    }
}