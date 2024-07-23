class Solution {
    public int[] frequencySort(int[] nums) {
        // Count the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a list of pairs (number, frequency) for sorting
        List<Pair> pairs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            pairs.add(new Pair(entry.getKey(), entry.getValue()));
        }

        // Sort the pairs based on frequency and then number in descending order
        Collections.sort(pairs, (a, b) -> {
            if (a.frequency != b.frequency) {
                return a.frequency - b.frequency;
            } else {
                return b.number - a.number;
            }
        });

        // Reconstruct the sorted array
        int[] result = new int[nums.length];
        int index = 0;
        for (Pair pair : pairs) {
            int num = pair.number;
            int freq = pair.frequency;
            while (freq-- > 0) {
                result[index++] = num;
            }
        }
        return result;
    }

    static class Pair {
        int number;
        int frequency;

        Pair(int number, int frequency) {
            this.number = number;
            this.frequency = frequency;
        }
    }
}