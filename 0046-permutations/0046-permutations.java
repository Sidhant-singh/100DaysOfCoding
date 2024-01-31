class Solution {
    public static void helper(int[] nums, int idx, List<List<Integer>> ans) {
        int n = nums.length;
        if (idx == n - 1) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                l.add(nums[i]);
            }
            ans.add(l);
            return;
        }
        for (int i = idx; i < n; i++) {
            swap(i, idx, nums);
            helper(nums, idx + 1, ans);
            swap(i, idx, nums); // here the nums array is being passed by refferrence in java so the changes are directly affecting the original array 
                                //so we have to undo the changes made due to which backtracking is being done.
        }
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,0,res);
        return res;
    }
}