class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (set.contains(-num)) {
                max = Math.max(max, num);
            }
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }
}