class Solution {
    
    public boolean convert(int x ,int y){
        String a = String.valueOf(x);
        String b = String.valueOf(y);
        
        String ord1 = a+b;
        String ord2 = b+a;
        
        return ord1.compareTo(ord2) < 0;
    }
    public String largestNumber(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(convert(nums[j],nums[j+1])){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        
        if(nums[0] == 0){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            String k = String.valueOf(nums[i]);
            sb.append(k);
        }
        
        return sb.toString();
    }
}