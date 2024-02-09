class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> dp = new ArrayList<>();
        
        // Initializing the dp list
        for (int i = 0; i < n; i++) {
            dp.add(new ArrayList<>());
        }
        
        // Base case: All elements are divisible by themselves
        for (int i = 0; i < n; i++) {
            dp.get(i).add(nums[i]);
        }
        
        // Dynamic programming to find the largest divisible subset
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp.get(i).size() < dp.get(j).size() + 1) {
                    dp.set(i, new ArrayList<>(dp.get(j)));
                    dp.get(i).add(nums[i]);
                }
            }
        }

        // Finding the subset with the maximum length
        List<Integer> result = new ArrayList<>();
        for (List<Integer> subset : dp) {
            if (subset.size() > result.size()) {
                result = subset;
            }
        }
        
        return result;
    }
}