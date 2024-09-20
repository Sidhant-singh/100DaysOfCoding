class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length()==1) return 1;
        StringBuilder sb = new StringBuilder(s);
        int j = sb.length()-1;
        while(j>=0){
            if(sb.charAt(j)==' ') j--;
            else break;
        }
        if(j<0) return 0;
        int i = j;
        while(j>= 0 && sb.charAt(j) !=' '){
            j--;
        }
        
        return i-j;
    }
}