class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int max = 0;
        int curr = 0;
        while(left<=right){
            int width = right - left;

            int min_height = Math.min(height[left],height[right]);
            curr = width * min_height;
            max = Math.max(max,curr);

            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}