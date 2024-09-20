class Solution {
    public boolean checkPall(String str){
       StringBuilder s = new StringBuilder(str);
        return s.toString().equals(s.reverse().toString());
    }
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i =0;
        int j = sb.length()-1;
        while(j>=0){
            String a = sb.substring(i,j+1);
            if(checkPall(a)){
                break;
            }
            j--;
        }
//         we have the longest pallindrome now
        String ans = sb.substring(j+1);
        
        StringBuilder rev = new StringBuilder(ans);
        return rev.reverse().append(s).toString();
    }
}