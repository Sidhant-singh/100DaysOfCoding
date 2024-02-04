class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) break; // If nums[i] > 0, then sum=nums[i]+nums[l]+nums[r] > 0
            int l = i + 1, r = n - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) l++;
                else if (sum > 0) r--;
                else {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l + 1 <= r && nums[l] == nums[l + 1]) l++; // Skip duplicate nums[l]
                    l++;
                    r--;
                }
            }

            while (i + 1 < n && nums[i + 1] == nums[i]) i++; // Skip duplicate nums[i]
        }

        return ans;
    }
    }
