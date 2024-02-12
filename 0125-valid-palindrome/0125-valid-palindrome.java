class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        
        int start =0 ;
        int end = s.length()-1;
        
        while(start<=end){
            int char_first = s.charAt(start);
            int char_last = s.charAt(end);
            
            if (!Character.isLetterOrDigit(char_first )) {
        		start++;
        	} else if(!Character.isLetterOrDigit(char_last)) {
        		end--;
        	} else {
        		if (Character.toLowerCase(char_first) != Character.toLowerCase(char_last)) {
        			return false;
        		}
        		start++;
        		end--;
        	}
        }
        return true;
    }
}