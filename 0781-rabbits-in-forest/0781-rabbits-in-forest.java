class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int nums : answers){
            // if the key exists it will return the frequency of the key and incremented by 1
            map.put(nums+1,map.getOrDefault(nums+1,0)+1);
        }
        int ans = 0;
        for(int key : map.keySet()){
            int freq = map.get(key);
            
            int q = freq/key;
            int r = freq%key;
            
            ans += q*key;
            if(r>0){
                ans += key;
            }
        }
        
        return ans;
    }
}