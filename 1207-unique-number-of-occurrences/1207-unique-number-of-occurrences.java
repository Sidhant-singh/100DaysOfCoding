class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int key = arr[i];
            if(map.containsKey(key)){
                int freq = map.get(key);
                map.put(key,freq+1);
            }
            else map.put(key,1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int key : map.keySet()){
            set.add(map.get(key));
        }
        
        if(set.size()!=map.size()) return false;
        else return true;
    }
}