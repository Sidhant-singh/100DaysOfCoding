
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> ans = new ArrayList<>();
        
        for (int[] inter : intervals) {
//             prev end < curr start
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < inter[0]) {
                ans.add(inter); // Add non-overlapping interval
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], inter[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
