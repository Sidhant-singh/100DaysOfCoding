class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<digits.length;i++){
            int key = digits[i];
            if(map.containsKey(key)){
                int freq = map.get(key);
                map.put(key,freq+1);
            }
            else map.put(key,1);
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i=100;i<=999;i+=2){
            int x = i;
            int c = x%10; x /= 10;
            int b = x%10; x/= 10;
            int a = x;
            
            if(map.containsKey(a)){
                int afreq = map.get(a);
                map.put(a,afreq-1);
                if(afreq==1) map.remove(a);
                if(map.containsKey(b)){
                    int bfreq = map.get(b);
                    map.put(b,bfreq-1);
                    if(bfreq==1) map.remove(b);
                if(map.containsKey(c)){
                    ans.add(i);
                }
                map.put(b,bfreq);
                }
                map.put(a,afreq);
            }
        }
        int arr[] = new int[ans.size()];
        for(int i=0;i<arr.length;i++){
            arr[i] = ans.get(i);
        }
        
        return arr;
    }
}