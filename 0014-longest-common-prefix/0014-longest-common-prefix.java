class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        // sort the array due to which it becomes in lexographical order
        Arrays.sort(strs);
        // we have to compare only the first and the last string in array.
        String first = strs[0];
        String last = strs[strs.length-1];
        for(int i=0;i<Math.min(first.length(),last.length());i++){
            if(first.charAt(i)!=last.charAt(i)){
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}