class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Map<String, Integer> prefixMap = new HashMap<>();

        // Fill the map with prefixes from arr1
        for (int x : arr1) {
            String strNum = String.valueOf(x);
            StringBuilder prefix = new StringBuilder();

            for (char ch : strNum.toCharArray()) {
                prefix.append(ch);
                prefixMap.put(prefix.toString(), prefixMap.getOrDefault(prefix.toString(), 0) + 1);
            }
        }

        int maxLen = 0;

        // Check for common prefixes in arr2
        for (int x : arr2) {
            String strNum = String.valueOf(x);
            StringBuilder prefix = new StringBuilder();

            for (char ch : strNum.toCharArray()) {
                prefix.append(ch);
                if (prefixMap.containsKey(prefix.toString())) {
                    maxLen = Math.max(maxLen, prefix.length());
                }
            }
        }

        return maxLen;
    }
}