class Solution {
    public boolean check(int left,int right,String str){
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)) return false;
            left++;
            right--;
        }
        
        return true;
    } 
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return check(left+1,right,s) || check(left,right-1,s);
            }
            left++;
            right--;
        }
        
        return true;
    }
}