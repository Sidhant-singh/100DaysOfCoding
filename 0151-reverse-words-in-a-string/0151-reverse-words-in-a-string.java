class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder ans = new StringBuilder();
        int j = sb.length() - 1;
        
        while (j >= 0) {
            // Skip spaces
            while (j >= 0 && sb.charAt(j) == ' ') {
                j--;
            }
            // Find the start of the word
            int i = j;
            while (i >= 0 && sb.charAt(i) != ' ') {
                i--;
            }
            // Add the word to the result
            if (j >= 0) {
                if (ans.length() > 0) {
                    ans.append(" ");
                }
                ans.append(sb.substring(i + 1, j + 1));
            }
            j = i;
        }
        
        return ans.toString();
    }
}
