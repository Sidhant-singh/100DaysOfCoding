class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int count=0; 
        while(tickets[k]>0){
            for(int i=0;i<n;i++){
                if(tickets[i]==0) continue;
                if(tickets[k]==0) break;
                else {
                    tickets[i]--;
                    count++;
                }
            }
        }
        return count;
    }
}