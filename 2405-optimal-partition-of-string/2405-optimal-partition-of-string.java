class Solution {
    public int partitionString(String s) {
        int count = 1; // Start with 1 partition
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (sb.toString().contains(String.valueOf(currentChar))) {
                count++;
                sb.setLength(0); // Clear the StringBuilder to start a new partition
            }
            sb.append(currentChar);
        }

        return count;
    }
}
