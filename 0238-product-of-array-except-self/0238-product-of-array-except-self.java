class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int []left = new int [n];
        int []right = new int[n];

        left[0] = nums[0];
        for(int i=1;i<n;i++){
           int pro = left[i-1]*nums[i];
           left[i] = pro;
        }

        right[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            int pro2 = right[i+1]*nums[i];
            right[i] = pro2;
        }

        int res[] = new int[n];
        res[0] = right[1];
        res[n-1] = left[n-2];

        for(int i=1;i<n-1;i++){
            int pro3 = left[i-1] * right[i+1];
            res[i] = pro3;
        }

        return res;
    }
}