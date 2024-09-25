class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String []strNum = new String[n];
        
        for(int i=0;i<n;i++){
            strNum[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strNum,(a,b)->(b+a).compareTo(a+b));
        
        if (strNum[0].equals("0")) {
                return "0";
            }        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            String t = strNum[i];
            sb.append(t);
        }
        
        return sb.toString();
    }
}