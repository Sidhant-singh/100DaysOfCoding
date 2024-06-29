class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] arr = new char[128]; // '\0' by default
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            char dh = t.charAt(i);
            int idx = (int)ch;
            if(arr[idx]=='\0') arr[idx] = dh;
            else{
                if(arr[idx]!=dh) return false;
            }
        }
         char[] brr = new char[128]; // '\0' by default
        for(int i=0;i<s.length();i++){
            char ch = t.charAt(i);
            char dh = s.charAt(i);
            int idx = (int)ch;
            if(brr[idx]=='\0') brr[idx] = dh;
            else{
                if(brr[idx]!=dh) return false;
            }
        }
        return true;
    }
}