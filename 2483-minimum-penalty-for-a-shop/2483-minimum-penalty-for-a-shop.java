class Solution {
    public int bestClosingTime(String str){
        int n = str.length();
        int []pre = new int[n+1];
        for(int i=1;i<=n;i++){
            pre[i] = pre[i-1];
            if(str.charAt(i-1)=='N') pre[i] += 1;
        }
        
        int []suff = new int[n+1];
        for(int i=n-1;i>=0;i--){
            suff[i] = suff[i+1];
            if(str.charAt(i)=='Y') suff[i] += 1;
        }
        int []penalty = new int[n+1];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=n;i++){
            penalty[i] = pre[i] + suff[i];
            min = Math.min(min,penalty[i]);
        }
        
        for(int i=0;i<=n;i++){
            if(penalty[i]==min) return i;
        }
        
        return 2324;
    }
}