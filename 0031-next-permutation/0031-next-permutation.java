class Solution {

    public static void swap(int start, int end, int[] nums) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;
        // Finding the break point
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            reverse(nums, 0, n - 1);
        } else {
            for (int i = n - 1; i > idx; i--) {
                if (nums[i] > nums[idx]) {
                    swap(i, idx, nums);
                    break; // Break after the first valid swap
                }
            }
            reverse(nums, idx + 1, n - 1);
        }
    }
}
