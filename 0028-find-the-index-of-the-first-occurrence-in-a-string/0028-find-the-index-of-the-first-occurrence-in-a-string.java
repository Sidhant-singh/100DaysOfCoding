class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0; // Edge case: empty needle
        
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        
        // Iterate through the haystack
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            // Check if the substring starting at index i matches the needle
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i; // Found the first occurrence of needle in haystack
            }
        }
        
        return -1;
    }
}